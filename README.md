This is the original algorithm.

Generate two large random primes, p and q, of approximately equal size such that their product n = pq is of the required bit length, e.g. 1024 bits. [See note 1].
Compute n = pq and (phi) ? = (p-1)(q-1). [See note 6].
Choose an integer e, 1 < e < phi, such that gcd(e, phi) = 1. [See note 2].
Compute the secret exponent d, 1 < d < phi, such that ed ? 1 (mod phi). [See note 3].
The public key is (n, e) and the private key (d, p, q). Keep all the values d, p, q and phi secret. [We prefer sometimes to write the private key as (n, d) because you need the value of n when using d. Other times we might write the key pair as ((N, e), d).]
n is known as the modulus.
e is known as the public exponent or encryption exponent or just the exponent.
d is known as the secret exponent or decryption exponent.
A practical key generation algorithm

Incorporating the advice given in the notes below, a practical algorithm to generate an RSA key pair is given below. Typical bit lengths are k = 1024, 2048, 3072, 4096,..., with increasing computational expense for larger values. You will not go far wrong if you choose e as 65537 (=0x10001) in step (1).

Algorithm: Generate an RSA key pair.
INPUT: Required modulus bit length, k. 
OUTPUT: An RSA key pair ((N,e), d) where N is the modulus, the product of two primes (N=pq) not exceeding k bits in length; e is the public exponent, a number less than and coprime to (p-1)(q-1); and d is the private exponent such that ed ? 1 (mod (p-1)(q-1)). 
Select a value of e from {3, 5, 17, 257, 65537}
repeat
   p < genprime(k/2)
until (p mod e) ? 1
repeat
   q < genprime(k - k/2)
until (q mod e) ? 1
N < pq
L < (p-1)(q-1)
d < modinv(e, L)
return (N, e, d)
The function genprime(b) returns a prime of exactly b bits, with the bth bit set to 1. Note that the operation k/2 is integer division giving the integer quotient with no fraction.

If you've chosen e = 65537 then the chances are that the first prime returned in steps (3) and (6) will pass the tests in steps (4) and (7), so each repeat-until loop will most likely just take one iteration. The final value of N may have a bit length slightly short of the target k. This actually does not matter too much (providing the message m is always < N), but some schemes require a modulus of exact length. If this is the case, then just repeat the entire algorithm until you get one. It should not take too many goes. Alternatively, use the trick setting the two highest bits in the prime candidates described in note 1.

Encryption

Sender A does the following:-

Obtains the recipient B's public key (n, e).
Represents the plaintext message as a positive integer m, 1 < m < n [see note 4].
Computes the ciphertext c = me mod n.
Sends the ciphertext c to B.
Decryption

Recipient B does the following:-

Uses his private key (n, d) to compute m = cd mod n.
Extracts the plaintext from the message representative m.
Digital signing

Sender A does the following:-

Creates a message digest of the information to be sent.
Represents this digest as an integer m between 1 and n-1. [See note 5].
Uses her private key (n, d) to compute the signature s = md mod n.
Sends this signature s to the recipient, B.
Signature verification

Recipient B does the following:-

Uses sender A's public key (n, e) to compute integer v = se mod n.
Extracts the message digest from this integer.
Independently computes the message digest of the information that has been signed.
If both message digests are identical, the signature is valid.
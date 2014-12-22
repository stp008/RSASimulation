Overview of Encryption and Public-Key Cryptosystems

Modern cryptosystems are typically classified as either public-key or private-key. Private-key encryption methods, such as the Data Encryption Standard(DES), use the same key to both encrypt and decrypt data. The key must be known only to the parties who are authorized to encrypt and decrypt a particular message. Public-key cryptosystems, on the other hand, use different keys to encrypt and decrypt data. The public-key is globally available. The private-key is kept confidential.
The Key Distribution Problem

Private-key systems suffer from the key distribution problem. In order for a secure communication to occur, the key must first be securely sent to the other party. An unsecure channel such as a data network can not be used. Couriers or other secure means are typically used. Public-key systems do not suffer from this problem because of their use of two different keys. Messages are encrypted with a public key and decrypted with a private key. No keys need to be distributed for a secure communication to occur.
Public-Key Cryptosystems

A user wishing to exchange encrypted messages using a public-key cryptosystem would place their public encryption procedure, E, in a public file. The user's corresponding decryption procedure, D, is kept confidential. Rivest, Shamir, and Adleman provide four properties that the encryption and decryption procedures have[3]:
Deciphering the enciphered form of a message M yields M. That is, D(E(M)) = M
E and D are easy to compute.
Publicly revealing E does not reveal an easy way to compute D. As such, only the user can decrypt messages which were encrypted with E. Likewise, only the user can compute D efficiently.
Deciphering a message M and then enciphering it results in M. That is, E(D(M)) = M
As Rivest, Shamir, and Adleman point out, if a procedure satisfying property (3) is used, it is extremely impractical for another user to try to decipher the message by trying all possible messages until they find one such that E(M) = C.
A function satisfying properties (1) - (3) is called a "trap-door one-way function". It is called "one-way" because it is easy to compute in one direction but not the other. It is called "trap-door" because the inverse functions are easy to compute once certain private, "trap-door" information is known.

The Public-Key Cryptosystem Encryption and Decryption Process

Suppose user A wants to send a private message, M, to user B.
User A gets User B's public key from some public source.
User A encrypts message M using B's public key. This produces a ciphertext message, C
Ciphertext message C is sent over some communication channel
Upon receipt, user B decrypts message C using their private key. This results in the original message M.
Digital Signatures

Property (4) of public-key cryptosystems allows a user to digitally "sign" a message they send. This digital signature provides proof that the message originated from the designated sender. In order to be effective, digital signature need to be both message-dependent as well as signer-dependent. This would prevent electronic "cutting and pasting" as well as modification of the original message by the recipient.
Suppose user A wanted to send a "digitally-signed" message, M, to user B:

User A applies their decryption procedure to M. This results in ciphertext C.
User A applies the encryption procedure of user B to C. This results in message S.
Ciphertext message S is sent over some communication channel
Upon receipt, user B applies their decryption procedure to S. This results in ciphertext message C.
User B applies user A's encryption procedure to message C. This results in the original message, M.
User B cannot alter the original message or use the signature with any other message. To do so would require user B to know how to decrypt a message using A's decryption procedure.
The RSA Algorithm

The Rivest-Shamir-Adleman (RSA) algorithm is one of the most popular and secure public-key encryption methods. The algorithm capitalizes on the fact that there is no efficient way to factor very large (100-200 digit) numbers.
Using an encryption key (e,n), the algorithm is as follows:

Represent the message as an integer between 0 and (n-1). Large messages can be broken up into a number of blocks. Each block would then be represented by an integer in the same range.
Encrypt the message by raising it to the eth power modulo n. The result is a ciphertext message C.
To decrypt ciphertext message C, raise it to another power d modulo n
The encryption key (e,n) is made public. The decryption key (d,n) is kept private by the user.
How to Determine Appropriate Values for e, d, and n

Choose two very large (100+ digit) prime numbers. Denote these numbers as p and q.
Set n equal to p * q.
Choose any large integer, d, such that GCD(d, ((p-1) * (q-1))) = 1
Find e such that e * d = 1 (mod ((p-1) * (q-1)))
Rivest, Shamir, and Adleman provide efficient algorithms for each required operation[4].
How secure is a communication using RSA?

Cryptographic methods cannot be proven secure. Instead, the only test is to see if someone can figure out how to decipher a message without having direct knowledge of the decryption key. The RSA method's security rests on the fact that it is extremely difficult to factor very large numbers. If 100 digit numbers are used for p and q, the resulting n will be approximately 200 digits. The fastest known factoring algorithm would take far too long for an attacker to ever break the code. Other methods for determining d without factoring n are equally as difficult.
Any cryptographic technique which can resist a concerted attack is regarded as secure. At this point in time, the RSA algorithm is considered secure.

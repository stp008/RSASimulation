package RSASimulation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelperRSA {

	private static final Logger log = LoggerFactory.getLogger(HelperRSA.class);

	private static long e = 3;

	public static void main(String[] args) {
		encode(5, 6, 18);
		decode(5, 6, 12);
	}

	public static long euclid(long a, long b) {
		if (b == 0)
			return a;
		log.debug("METHOD: euclid");

		return euclid(b, a % b);
	}

	public static boolean primality(int N) {
		if (N < 0)
			return false;

		log.debug("METHOD: primality");

		long a = (long) Math.random() * (N - 1);

		if (Math.pow(a, N - 1) % N == 1 % N) {
			return true;
		} else {
			return false;
		}
	}

	public static long encode(long p, long q, long x) {
		long[] publicKeyArray = getPublicKey(p, q);
		long N = publicKeyArray[0];

		long msg = ((long) Math.pow(x, e)) % N;
		log.debug("METHOD: encode");
		log.debug("N = " + N);
		log.debug("Encoded message: " + msg + ", Original msg: " + x);

		return msg;
	}

	public static long decode(int p, int q, int y) {
		long N = p * q;
		long d = getPrivateKey(p, q);

		log.debug("METHOD: decode");
		log.debug("N = " + N);
		log.debug("d = " + N);

		long msg = ((long) Math.pow(y, d)) % N;
		log.debug("Decoded msg: " + msg + ", Encoded msg: " + y);

		return msg;
	}

	public static long[] getPublicKey(long p, long q) {
		long[] publicKey = new long[2];
		long N = p * q;
		e = 3;
		while (euclid((p - 1) * (q - 1), e) != 1) {
			e++;
		}

		publicKey[0] = N;
		publicKey[1] = e;
		log.debug("METHOD: getPublicKey");
		log.debug("p = " + p);
		log.debug("q = " + q);
		log.debug("N = " + N);
		log.debug("e = " + e);
		log.debug("publicKey: " + publicKey[0] + ", " + e);

		return publicKey;
	}

	public static long getPrivateKey(long p, long q) {
		long multiplication = (p - 1) * (q - 1);
		long[] privateKeyArray = extEuclid(e, multiplication);
		long privateKey = privateKeyArray[1];
		while (privateKey < 0) {
			privateKey += multiplication;
		}

		log.debug("METHOD: getPrivateKey");
		log.debug("p = " + p);
		log.debug("q = " + q);
		log.debug("(p-1)(q-1) = " + multiplication);
		log.debug("privateKey = " + privateKey);

		return privateKey;
	}

	// return array [d, a, b] such that d = gcd(p, q), ap + bq = d
	public static long[] extEuclid(long p, long q) {
		if (q == 0)
			return new long[] { p, 1, 0 };

		long[] vals = extEuclid(q, p % q);
		long d = vals[0];
		long a = vals[2];
		long b = vals[1] - (p / q) * vals[2];

		log.debug("METHOD: extEuclid");

		return new long[] { d, a, b };
	}

}

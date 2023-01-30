// import java.util.*;
// import java.lang.*;
// import java.math.BigInteger;

// public class RsaKeyGeneration
// {
//     public static void main(String[] args) {
//         Random rand1 = new Random(System.currentTimeMillis());
//         Random rand2 = new Random(System.currentTimeMillis()*10);
//         int pubkey = Integer.parseInt(args[1]);

//         BigInteger bigB_p = BigInteger.probablePrime(32,rand1);
//         BigInteger bigB_q = BigInteger.probablePrime(32,rand2);
//         BigInteger bigB_n = bigB_p.multiply(bigB_q); 
//         BigInteger bigB_p_1 = bigB_p.subtract(new BigInteger("1"));
//         BigInteger bigB_q_1 = bigB_q.subtract(new BigInteger("1"));
//         BigInteger bigB_p_1_q_1 = bigB_p_1.multiply(bigB_q_1);

//         while(true)
//         {
//             BigInteger BigB_GCD = bigB_p_1_q_1.gcd(new BigInteger(" "+pubkey));
//             if(BigB_GCD.equals(BigInteger.ONE))
//             {
//                 break;
//             }
//             pubkey++;
//         }
//         BigInteger bigB_pubkey = new BigInteger(" "+pubkey);
//         BigInteger bigB_prvkey = bigB_pubkey.modInverse(bigB_p_1_q_1);
//         System.out.println("Public Key: "+bigB_pubkey+","+bigB_n);
//         System.out.println("Private Key: "+bigB_prvkey+","+bigB_n);
//     }
// }



import java.io.*;
import java.util.*;
import java.math.BigInteger;
import java.lang.*;

class RsaKeyGeneration
{
	public static void main(String args[])
	{
		Random rand1 = new Random(System.currentTimeMillis());
		Random rand2 =new Random (System.currentTimeMillis()*10);
		int pubkey=Integer.parseInt(args[0]);
		BigInteger p = BigInteger.probablePrime(32,rand1);
		BigInteger q = BigInteger.probablePrime(32,rand2);
		BigInteger n = p.multiply(q);
		BigInteger p_1 = p.subtract(new BigInteger("1"));
		BigInteger q_1 = q.subtract(new BigInteger("1"));
		BigInteger p_1_q_1 = p_1.multiply(q_1);
		while(true)
		{
			BigInteger GCD = p_1_q_1.gcd(new BigInteger(""+pubkey));
		        if(GCD.equals(BigInteger.ONE))
		        {
		        break;
		        }
		        pubkey++;
		}
		BigInteger publkey = new BigInteger(""+pubkey);
		BigInteger privkey = publkey.modInverse(p_1_q_1);
		System.out.println("Pubkey"+publkey+","+n);
		System.out.println("Privatekey "+privkey+","+n);
	}
}

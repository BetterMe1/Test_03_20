package Test_0320;

/*
342. 4的幂
 给定一个整数 (32 位有符号整数)，请编写一个函数来判断它是否是 4 的幂次方。

示例 1:
输入: 16
输出: true
示例 2:
输入: 5
输出: false
进阶：
你能不使用循环或者递归来完成本题吗？
 */
/*
 * 分析：
 * 若num小于0，或num不是2的幂，那么num肯定不是4的幂。
 * 而4的幂二进制位上的1总是出现在奇数位上，当不是4的幂却是2的幂时二进制位上的1现在偶数位上。
 */
//public class LeetcodeTest {
//	public static void main(String[] args) {
//		Solution So = new Solution();
//	}
//}
//class Solution {
//    public boolean isPowerOfFour(int num) {
//    	if(num<0 || (num &(num-1)) !=0){//如果num小于0，或此数不是2的幂，返回false.
//    		return false;
//    	}
//    	return (num & 0x55555555) != 0;//num二进制位上的1在奇数位，就返回true，否则返回false.
//    }
//}
/*
1012. 十进制整数的反码  显示英文描述  我的提交返回竞赛
每个非负整数 N 都有其二进制表示。例如， 5 可以被表示为二进制 "101"，11 可以用二进制 "1011" 表示，依此类推。
注意，除 N = 0 外，任何二进制表示中都不含前导零。
二进制的反码表示是将每个 1 改为 0 且每个 0 变为 1。例如，二进制数 "101" 的二进制反码为 "010"。
给定十进制数 N，返回其二进制表示的反码所对应的十进制整数。

示例 1：
输入：5
输出：2
解释：5 的二进制表示为 "101"，其二进制反码为 "010"，也就是十进制中的 2 。
示例 2：
输入：7
输出：0
解释：7 的二进制表示为 "111"，其二进制反码为 "000"，也就是十进制中的 0 。
示例 3：
输入：10
输出：5
解释：10 的二进制表示为 "1010"，其二进制反码为 "0101"，也就是十进制中的 5 。
提示：
0 <= N < 10^9
 */
/*
 * 分析：
 * 先算出N的二进制反码，也就是N ^ Integer.MAX_VALUE，此反码考虑二进制的全部32位。
 * 由于题中要求不考虑前导零，所以我们在计算反码的十进制数时不考虑前导零，
 * 以下代码中因计算反码的十进制数用了for循环累加每一位，每累加一次，N/2，且N/2!=0时跳出循环
 */
public class LeetcodeTest {
	public static void main(String[] args) {
		Solution So = new Solution();
		int N = 5;
		System.out.println(So.bitwiseComplement(N));
	}
}
class Solution {
    public int bitwiseComplement(int N) {
        if(N ==0){
            return 1;
        }
        int t = N ^ Integer.MAX_VALUE;
        int sum = 0;
        for(int i = 0,d = 1; i<30 && N!=0; i++,N/=2){
            sum += d*((t>>i)&1);
            d *= 2;
        }
        return sum;
    }
}
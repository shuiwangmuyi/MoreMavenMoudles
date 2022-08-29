package FinalShallMoudel;


/**
 * @title: FinalShallDomeText
 * @Author Wy
 * @Date: 2022/8/26 14:22
 * @Version 1.0
 */

import org.junit.jupiter.api.Test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 激活FinalShall
 *
 * 随便输入账号密码 然后点击离线激活，讲机器码复制到下面即可
 */
public class FinalShallDomeTest {
    @Test
    public void  test()  {
      try {
          @SuppressWarnings("resource")
          //这里将值改为离线机器码
//        String machineCode="admin@b70df5fd8f175851";
          String machineCode="admin@6e1350868434d82b";
        generateKey(machineCode);
      }catch (Exception e){
          System.out.println(e);
      }
    }
    public static void generateKey(String hardwareId) throws NoSuchAlgorithmException {
        String proKey = transform(61305 + hardwareId + 8552);
        String pfKey = transform(2356 + hardwareId + 13593);
        System.out.println("请将此行复制到离线激活中：" + proKey);
    }
    public static String transform(String str) throws NoSuchAlgorithmException {
        @SuppressWarnings("unused")
        String md5 = hashMD5(str);
        return hashMD5(str).substring(8, 24);
    }

    public static String hashMD5(String str) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("MD5");
        byte[] hashed = digest.digest(str.getBytes());
        StringBuilder sb = new StringBuilder();
        for (byte b : hashed) {
            int len = b & 0xFF;
            if (len < 16) {
                sb.append("0");
            }
            sb.append(Integer.toHexString(len));
        }
        return sb.toString();
    }

}


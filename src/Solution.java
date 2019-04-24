import java.util.ArrayList;
import java.util.List;

/*
将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。

比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：

L   C   I   R
E T O E S I I G
E   D   H   N
 */
public class Solution {
    public String convert(String s,int numRows){
        if(numRows==1)
            return s;
        int curRow=0;
        boolean goingdown=false;
        List<StringBuilder> row=new ArrayList<StringBuilder>();
        for(int i=0;i<Math.min(numRows,s.length());i++){
            row.add(new StringBuilder());
        }
        for(int i=0;i<s.length();i++){
            row.get(curRow).append(s.charAt(i));
            if(curRow==numRows-1||curRow==0)goingdown=!goingdown;
            curRow+=goingdown?1:-1;
        }
        StringBuilder res=new StringBuilder();
        for(StringBuilder rows:row)res.append(rows);
        return res.toString();
    }
}

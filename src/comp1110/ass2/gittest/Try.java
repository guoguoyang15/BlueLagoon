package comp1110.ass2.gittest;

import java.util.Random;

public class Try {
    public static void main(String[] args) {
        int[]a=new int[32];
        String statement="a 13 2; c 0 E; i 6 0,0 0,1 0,2 0,3 0,4 0,5 0,6 0,7 0,8 0,9 0,10 0,11 1,0 1,12 2,0 2,11 3,0 3,12 4,0 4,11 5,0 5,12 6,0 6,11 7,0 7,12 8,0 8,11 9,0 9,12 10,0 10,11 11,0 11,12 12,0 12,1 12,2 12,3 12,4 12,5 12,6 12,7 12,8 12,9 12,10 12,11; i 6 2,4 2,5 2,6 2,7; i 9 4,4 4,5 4,6 4,7; i 9 6,5 6,6 7,5 7,7 8,5 8,6; i 12 2,2 3,2 3,3 4,2 5,2 5,3 6,2 7,2 7,3; i 12 2,9 3,9 3,10 4,9 5,9 5,10 6,9 7,9 7,10; i 12 9,2 9,10 10,2 10,3 10,4 10,5 10,6 10,7 10,8 10,9; s 0,3 0,8 1,0 1,12 2,2 2,4 2,7 2,9 4,2 4,5 4,6 4,9 5,0 5,12 6,2 6,5 6,6 6,9 8,0 8,5 8,6 8,11 9,2 9,10 10,3 10,5 10,6 10,8 11,0 11,12 12,4 12,7; r C B W P S; p 0 0 0 0 0 0 0 S T; p 1 0 0 0 0 0 0 S T;";
        String []sentence=statement.split(";");
        String target =null;
        String replace;
        for(int i = 0; i < 14; i++)
        {
            if(sentence[i].startsWith(" s")){
                target=sentence[i];
                break;
            }
        }
        target=target.replace(" s ","");
        Random r=new Random();
        int rand;
        for(int i=0;i<32;i++)
        {

            do{rand=r.nextInt(32);
                if(a[rand]==0){
                    a[rand]=i;
                    break;
                }
            }while (true);
        }
        System.out.println(statement);
        System.out.println(distributeResources(statement));
        }
    public static String distributeResources(String stateString) {
        //add a space at front to make sure that for every statement, the second char of the substring is the type of statement
        //stateString = " " + stateString;
        String[] statement = stateString.split(";");
        String target=null;
        for(int i=0;i<14;i++)
        {
            if(statement[i].startsWith(" s")) {
                target=statement[i];
                break;
            }
        }
        //先用target截取s开头的字符串
        target=target.replace(" s ","");
        //切除掉开头的无关字符
        String[]stoneCircle=target.split(" ");
        //分离出来字符串中的顺序字符
        String[]random=new String[32];
        //另外新设一个字符串数组
        Random r=new Random();
        int []a=new int [32];
        int rand;
        for(int i=0;i<32;i++)
        {

            do{rand=r.nextInt(32);
                if(a[rand]==0){
                    a[rand]=i;
                    break;
                }
            }while (true);
        }
        for(int i=0;i<32;i++)
        {
            random[i]=stoneCircle[a[i]];
        }
        // 随机一串0~31的数组，把新数据记录进新的字符串里面
        String C=random[0]+" "+random[1]+" "+random[2]+" "+random[3]+" "+random[4]+" "+random[5]+" ";
        String B=random[6]+" "+random[7]+" "+random[8]+" "+random[9]+" "+random[10]+" "+random[11]+" ";
        String W=random[12]+" "+random[13]+" "+random[14]+" "+random[15]+" "+random[16]+" "+random[17]+" ";
        String P=random[18]+" "+random[19]+" "+random[20]+" "+random[21]+" "+random[22]+" "+random[23]+" ";
        String S=random[24]+" "+random[25]+" "+random[26]+" "+random[27]+" "+random[28]+" "+random[29]+" "+random[30]+" "+random[31];
        //先把各个资源的字符串表示出来
        String replaceString=" r C "+C+"B "+B+"W "+W+"P "+P+"S "+S;
        //直接用字符串加法，先另外拟一个字符串资源声明

        for(int i=0;i<12;i++)
        {
            if(statement[i].startsWith(" r")){
                stateString=stateString.replace(statement[i],replaceString);
            }
        }

        return stateString;
    }
    }




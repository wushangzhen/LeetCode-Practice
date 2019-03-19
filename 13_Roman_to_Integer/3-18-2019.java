class Solution {
    public int romanToInt(String s) {
        int res = 0;
        if (s.indexOf("IV") != -1) {
            res -= 2;
        }
        if (s.indexOf("IX") != -1) {
            res -= 2;
        }
        if (s.indexOf("XL") != -1) {
            res -= 20;
        }
        if (s.indexOf("XC") != -1) {
            res -= 20;
        }
        if (s.indexOf("CD") != -1) {
            res -= 200;
        }
        if (s.indexOf("CM") != -1) {
            res -= 200;
        }
        char c[]=s.toCharArray();
        int count=0; 
        for (;count<=s.length()-1;count++){
            if(c[count]=='M') res+=1000;
            if(c[count]=='D') res+=500;
            if(c[count]=='C') res+=100;
            if(c[count]=='L') res+=50;
            if(c[count]=='X') res+=10;
            if(c[count]=='V') res+=5;
            if(c[count]=='I') res+=1;
        }
        return res;
    }
}

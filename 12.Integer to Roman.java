class Solution
 {
    public String intToRoman(int num) 
    {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");

        int val[] = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String res = "";

        for (int i = 0; i < val.length; i++) 
        {
            if (num >= val[i]) 
            {
                int q = num / val[i];
                num = num % val[i];
                for (int j = 0; j < q; j++) 
                {
                    res += map.get(val[i]);
                }
            }
        }
        return res;
    }
}

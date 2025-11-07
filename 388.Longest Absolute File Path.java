class Solution {
    public int lengthLongestPath(String input) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        stack.push(0);

        for (String str : input.split("\n")) {
            int level = str.lastIndexOf("\t") + 1;
            int length = str.length() - level;

            while (stack.size() > level + 1)
                stack.pop();

            if (str.contains(".")) {
                max = Math.max(max, stack.peek() + length);
            } else {
                stack.push(stack.peek() + length + 1);
            }
        }
        return max;
    }
}

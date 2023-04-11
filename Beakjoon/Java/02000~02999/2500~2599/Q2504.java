import java.io.*;
import java.util.*;

public class Q2504 {
    static int A = -1, B = -2, C = -3, D = -4; // A = (, B = ), C = [, D = ]

    public static void main(String[] args) throws IOException {
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split("");
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            stack.push(bracketParseInt(arr[i]));
            if (stack.size() > 1) {
                if (stack.peek() == B || stack.peek() == D) {
                    if (stack.peek() == B) {
                        if (stack.get(stack.size() - 2) == A) {
                            stack.pop();
                            stack.pop();
                            stack.push(2);
                        } else if (stack.peek() == C) {
                            break;
                        } else {
                            if (stack.size() <= 2) {
                                break;
                            } else {
                                if (stack.get(stack.size() - 3) == A) {
                                    stack.pop();
                                    int num = stack.pop() * 2;
                                    stack.pop();
                                    stack.push(num);
                                } else if (stack.get(stack.size() - 3) == C) {
                                    break;
                                }
                            }
                        }
                    } else if (stack.peek() == D) {
                        if (stack.get(stack.size() - 2) == C) {
                            stack.pop();
                            stack.pop();
                            stack.push(3);
                        } else if (stack.peek() == A) {
                            break;
                        } else {
                            if (stack.size() <= 2) {
                                break;
                            } else {
                                if (stack.get(stack.size() - 3) == C) {
                                    stack.pop();
                                    int num = stack.pop() * 3;
                                    stack.pop();
                                    stack.push(num);
                                } else if (stack.get(stack.size() - 3) == A) {
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            if (stack.size() >= 2 && stack.get(stack.size() - 1) > 0 && stack.get(stack.size() - 2) > 0) {
                stack.push(stack.pop() + stack.pop());
            }
            if (i == arr.length - 1 && stack.size() == 1 && stack.peek() > 0) {
                answer = stack.peek();
            }
        }
        System.out.print(answer);
    }

    public static int bracketParseInt(String str) {
        int num = 0;
        if (str.equals("(")) {
            num = -1;
        } else if (str.equals(")")) {
            num = -2;
        } else if (str.equals("[")) {
            num = -3;
        } else if (str.equals("]")) {
            num = -4;
        }
        return num;
    }
}
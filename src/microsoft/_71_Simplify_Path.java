package microsoft;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _71_Simplify_Path {
    /**
     * Given an absolute path for a file (Unix-style), simplify it.
     *
     * For example,
     * path = "/home/", => "/home"
     * path = "/a/./b/../../c/", => "/c"
     * path = "/a/../../b/../c//.//", => "/c"
     * path = "/a//b////c/d//././/..", => "/a/b/c"
     *
     * In a UNIX-style file system, a period ('.') refers to the current directory, so it can be ignored in a simplified path. Additionally, a double period ("..") moves up a directory, so it cancels out whatever the last directory was. For more information, look here: https://en.wikipedia.org/wiki/Path_(computing)#Unix_style
     *
     * Corner Cases:
     *
     * Did you consider the case where path = "/../"?
     * In this case, you should return "/".
     * Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
     * In this case, you should ignore redundant slashes and return "/home/foo".
     */

    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] p = path.split("/");
        for (int i = 0; i < p.length; i++) {
            if (!stack.empty() && p[i].equals(".."))
                stack.pop();
            else if (!p[i].equals(".") && !p[i].equals("") && !p[i].equals(".."))
                stack.push(p[i]);
        }
        List<String> list = new ArrayList(stack);
        return "/"+String.join("/", list);
    }
}

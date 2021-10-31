package Test;

public class cKKOM1 {
    public static void main(String[] arg) {
        //영문자만 포함 가능(last name은 - 포함 가능
        //글자1 는 firstname의 이니셜
        //글자2 미들네임 이니셜
        //나머지 라스트네임 최대 8자까지 (하이픈 제거)
        //company는 컴패니 이름
        // 전부 소문자만 가능
        // 이미 있는 이름이면 2, 3, ...순서로 뒤에 붙이기
        solution("John Doe, Peter Parker, Mary Jane Watson-Parker, James Doe, John Elvis Doe, Jane Doe, Penny Parker","companaya"); //100100100100
    }

    public static String solution(String S, String C) {
        String ans = "";
        String[] names = S.split(", ");

        for(int i=0; i<names.length; i++) {
            String[] name = names[i].split(" ");
            String email = "";
            String ln = "";

            if(name.length==2) {
                email = email.concat(String.valueOf(name[0].toLowerCase().charAt(0)));
                ln = name[1].replace("-", "");
            } else {
                email = email.concat(String.valueOf(name[0].toLowerCase().charAt(0)));
                email = email.concat(String.valueOf(name[1].toLowerCase().charAt(0)));
                ln = name[2].replace("-", "");
            }

            if(ln.length()<8) {
                email = email.concat(ln.toLowerCase());
            } else{
                email = email.concat(ln.substring(0,8).toLowerCase());
            }

            if(ans.contains(email)) {
                email = email.concat("2");
                while(ans.contains(email)) {
                    int temp = email.charAt(email.length() - 1)+1;
                    email = email.replace(email.charAt(email.length()-1), (char) temp);

                }
            }
            ans = ans.concat(names[i] + " <"+email+"@"+C.toLowerCase()+".com>, ");
        }

        ans = ans.substring(0, ans.length()-2);

        return ans;
    }
}

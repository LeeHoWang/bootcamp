// 問題 5（手寫 code）
// 有一個 HashMap<String, ArrayList<String>> classMap，Key 係班別（例如 "1A", "1B"），Value 係該班學生姓名嘅 ArrayList。

// 請你用 entrySet() 寫一段 code：

// 逐個班別印出 班別: [學生名單]

// 將所有學生（跨班別）加入一個叫 allStudents 嘅 ArrayList

import java.util.HashMap;
import java.util.ArrayList;

public class m {
  public static void main(String[] args) {
    HashMap<String, ArrayList<String>> classMap = new HashMap<>();
    // 1A 班學生
    ArrayList<String> class1A = new ArrayList<>();
    for (HashMap.Entry<String, ArrayList<String>> entry : classMap.entrySet()) {
      System.out.println(entry.getKey() + ": " + entry.getValue());
    }

    ArrayList<String> allStudents = new ArrayList<>();
    for (HashMap.Entry<String, ArrayList<String>> entry : classMap.entrySet()) {
      allStudents.addAll(entry.getValue());
    }
  }
}
// 🎯 第一關：最基本嘅咖啡店
// 你想控制嘅行為（得 3 個）
// 編號	你想控制嘅行為
// 1	每種咖啡有自己嘅價錢
// 2	可以計算一杯咖啡嘅價錢
// 3	第日可以輕鬆加新款咖啡
// 你要做嘅嘢
// 設計 class 嚟達成上面 3 個控制目標。

// 最少要有一個 main() 測試：

// java
// Coffee c1 = new Coffee("Americano", 25);
// Coffee c2 = new Coffee("Latte", 35);
// System.out.println(c1.getPrice());  // 25
// System.out.println(c2.getPrice());  // 35

// 🎯 第二關：加配料
// 新增嘅控制目標（喺第一關基礎上加）
// 編號	你想控制嘅行為
// 4	咖啡可以加配料（例如奶、糖）
// 5	每種配料有自己嘅價錢
// 6	配料價錢可以獨立修改，唔影響 Coffee 嘅 code
// 你要做嘅嘢
// 修改／加入 class，令到以下 main() 可以運行：

// java
// public static void main(String[] args) {
//     // 基本咖啡
//     Coffee c1 = new Coffee("Americano", 25);
    
//     // 配料
//     Topping milk = new Topping("Milk", 5);
//     Topping sugar = new Topping("Sugar", 3);
    
//     // 咖啡加配料
//     c1.addTopping(milk);
//     c1.addTopping(sugar);
    
//     // 計算總價：25 + 5 + 3 = 33
//     System.out.println(c1.getTotalPrice());  // 33
// }
// 你需要決定／寫出：
// Topping class 有咩 attribute 同 method？

// Coffee class 需要加咩 attribute 同 method？



---

# 咖啡店點餐系統 — 五關練習題

---

## 第一關

### 控制目標
- 每種咖啡有自己嘅價錢
- 可以計算一杯咖啡嘅價錢
- 第日可以輕鬆加新款咖啡

### 題目
設計一個 `Coffee` class，包含：
- `name`（咖啡名稱）
- `price`（價錢）
- getter / setter
- 一個 `main()` 測試建立兩杯唔同嘅咖啡並印出價錢

---

## 第二關

### 控制目標
- 咖啡可以加配料（例如奶、糖）
- 每種配料有自己嘅價錢
- 配料價錢可以獨立修改，唔影響 Coffee 嘅 code

### 題目
1. 設計一個 `Ingredient` class，包含 `name` 同 `price`
2. 修改 `Coffee` class，可以儲存多種配料（用 `List<Ingredient>`）
3. 新增 `getTotalPrice()` 方法，回傳咖啡價錢 + 所有配料價錢
4. 測試：Americano ($25) + Milk ($5) + Sugar ($3) = $33

---

## 第三關

### 控制目標
- 同一種配料唔可以加重複（例如加兩次 Milk）

### 題目
1. 喺 `Ingredient` class override `equals()` 方法（用 name 比較）
2. 喺 `Coffee` class 新增 `isDuplicate()` 方法
3. 修改 `addIngredient()`，如果配料已存在就拒絕並印出提示
4. 測試：加兩次 Milk，第二次應該被拒絕

---

## 第四關

### 控制目標
- Black Coffee 唔可以加奶

### 題目
1. 建立 `BlackCoffee` class 繼承 `Coffee`
2. Override `addIngredient()` 方法
3. 如果嘗試加 Milk，拒絕並印出 "Black coffee cannot add milk!"
4. 其他配料（例如 Sugar）照常處理（包括檢查重複）
5. 測試：Black Coffee 加 Milk（拒絕）、加 Sugar（成功）

---

## 第五關

### 控制目標
- 優惠券只可以用一次
- 計算總價時要套用優惠券折扣

### 題目
1. 設計 `Coupon` class，包含：
   - `code`（優惠碼）
   - `discount`（折扣，例如 0.1 = 10% off）
   - `isApplied`（記錄用過未）
2. 新增 `applyDiscount(double originalPrice)` 方法：
   - 如果已經用過，印出 "Coupon already used!" 並回傳原價
   - 如果未用過，標記為已用，計算並回傳折扣後價錢
3. 測試：同一張 coupon 用兩次，第二次應該被拒絕

---
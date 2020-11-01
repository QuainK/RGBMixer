# 更新日志 Changelog

## 1.0.0 - 2020.10.22

### 修改 Changed

- 最低 Android API 版本升至 21。

  > Android 5.0 Lollipop

- 编译 Android API 版本升至 30。

  > Android 11 R

- 因为显示颜色的控件移除了所有文本，所以控件从 TextView 改用 View。

- 布局从线性布局 LinearLayout 改用约束布局 ConstraintLayout。

### 优化 Refactored

- 所有 java 文件中的字符串硬编码全部改成使用资源文件中的 string 资源，并使用占位符动态修改字符串，比如 %1\$s 表示该字符串的第一个占位符使用字符串类型）。

- 三个拖动条的事件监听器优化成只用一个，在处理事件方法中用选择结构判断传入的参数是哪个拖动条。

- 改动了一些对象名和变量名，更符合 Java 代码风格规范。

### 移除 Removed

- 移除显示被点击的拖动条控件 ID 的文本。

---

## 0.1.0 - 2018.05.15

### 增加 Added

- 基本实现功能，拖动 RGB 三个拖动条，屏幕实时显示对应的 RGB 颜色。

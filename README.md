RoundedProgressBar
==================

RoundedProgressBar can be used in Android APP. It is configurable.

This project contains RoundProgressBar and PausableProgressBar.

即圆形进度条和可暂停的原型进度条。

### 如何使用

#### XML

1. 在res/values文件夹下的attrs.xml文件中添加如下代码。

```
<declare-styleable name="RoundedProgressBar">
	<attr name="innerCircleColor" format="color"></attr>
	<attr name="progressBarColor" format="color"></attr>
	<attr name="ringColor" format="color"></attr>
	<attr name="innerCircleAlpha" format="integer"></attr>
	<attr name="progressBarAlpha" format="integer"></attr>
	<attr name="ringAlpha" format="integer"></attr>
	<attr name="ringWidth" format="dimension"></attr>
	<attr name="innerCircleRadius" format="dimension"></attr>
	<attr name="max" format="integer"></attr>
	<attr name="currentProgress" format="integer"></attr>
	<attr name="isDisplayText" format="boolean"></attr>
	<attr name="textColor" format="color"></attr>
	<attr name="textSize" format="dimension"></attr>
	<attr name="isStrokeStyle" format="boolean"></attr>
</declare-styleable>
```

2. 在界面布局的最顶层加上`xmlns:rpb="http://schemas.android.com/apk/res/com.example.RoundedProgressBar"`。
 
3. 在合适的位置上，添加RoundedProgressBar控件，为其设置系统控件属性和自定义属性。以下是一个可供参考的例子。        

```
<cn.dxy.textbook.ui.component.RoundedProgressBar
	android:id="@+id/book_library_list_item_rounded_progress_bar"
	android:layout_width="80dp"
	android:layout_height="80dp"
	android:layout_centerInParent="true"
	android:visibility="gone"

	rpb:ringWidth="5dp"
	rpb:innerCircleRadius="15dp"
	rpb:textSize="15sp"
	rpb:isStrokeStyle="false"
	rpb:ringColor="@color/black"
/>
```

#### Java

1. 从layout文件获取RoundedProgressBar，或新建一个RoundedProgressBar。
	* `RoundedProgressBar roundedProgressBar = ViewHolder.get(convertView,R.id.book_library_list_item_rounded_progress_bar);`
	
	* `RoundedProgressBar roundedProgressBar = new RoundedProgressBar(context, attrs);`
	
2. 通过setter方法，可设置其属性。

3. 调用`roundedProgressBar.setCurrentProgress(int)`，设置当前进度。

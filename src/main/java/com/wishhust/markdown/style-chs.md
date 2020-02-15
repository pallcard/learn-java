# Markdown风格指导

Markdown之所以伟大，很大程度上是因为它能够编写纯文本，并因此获得良好的格式化输出。
为了使下一个作者的记录保持整洁，您的标记应该尽可能简单并与整个文集保持一致。

我们力求平衡三个目标:

1. *源文本是可读和可移植的。*
2. *Markdown文件可以随时间和跨团队进行维护。*
3. *语法简单，容易记住。*

内容:

1.  [文档布局](#document-layout)
1.  [字符限制](#character-line-limit)
1.  [反斜杠](#trailing-whitespace)
1.  [标题](#headings)
    1.  [ATX-style 标题](#atx-style-headings)
    1.  [给标题增加间距](#add-spacing-to-headings)
1.  [列表](#lists)
    1.  [对长列表使用惰性编号](#use-lazy-numbering-for-long-lists)
    1.  [嵌套列表间距](#nested-list-spacing)
1.  [Code](#code)
    1.  [Inline](#inline)
    1.  [Codeblocks](#codeblocks)
    1.  [Declare the language](#declare-the-language)
    1.  [Escape newlines](#escape-newlines)
    1.  [Nest codeblocks within lists](#nest-codeblocks-within-lists)
1.  [Links](#links)
    1.  [Use informative Markdown link titles](#use-informative-markdown-link-titles)
1.  [Images](#images)
1.  [Prefer lists to tables](#prefer-lists-to-tables)
1.  [Strongly prefer Markdown to HTML](#strongly-prefer-markdown-to-html)

## 文档布局

一般来说，大多数文档都受益于以下布局的一些变化:

```markdown
# Document Title

Short introduction.

[TOC]

## Topic

Content.

## See also

* https://link-to-more-info
```

1.  `# 文档标题`: 第一个标题应该是第一级标题，并且在理想情况下应该与文件名相同或几乎相同。第一级标题用作页面 `<title>`.

1.  `作者`: *Optional*. 如果您想要声明文档的所有权，或者您对此非常自豪，请在标题下添加您自己。但是，修改历史通常就足够了。

1.  `简介` 1-3个句子，提供对主题的高层次概述。把自己想象成一个完全的新手，刚刚接触到你的“扩展Foo”文档，需要知道你认为理所当然的最基本的假设。“Foo是什么?我为什么要扩展它?"

1.  `[TOC]`: 如果你使用的主机支持目录，如Gitiles，在简短的介绍后加上' [TOC] '。See
    [`[TOC]` documentation](https://gerrit.googlesource.com/gitiles/+/master/Documentation/markdown.md#Table-of-contents).

1.  `## Topic`: 你的其他标题应该从第2级开始。

1.  `## See also`: 把杂项链接放在底部的用户谁想知道更多或没有找到她需要的。

## 字符限制

尽可能遵守项目的字符行限制。当违反规则时，长url和表通常是可疑的。(标题也不能包起来，但我们鼓励保持简短)。否则，包装你的文字:

```markdown
Lorem ipsum dolor sit amet, nec eius volumus patrioque cu, nec et commodo
hendrerit, id nobis saperet fuisset ius.

*   Malorum moderatius vim eu. In vix dico persecuti. Te nam saperet percipitur
    interesset. See the [foo docs](https://gerrit.googlesource.com/gitiles/+/master/Documentation/markdown.md).
```

通常，在长链接之前插入换行可以保持可读性，同时最小化溢出:

```markdown
Lorem ipsum dolor sit amet. See the
[foo docs](https://gerrit.googlesource.com/gitiles/+/master/Documentation/markdown.md)
for details.
```

## 反斜杠

不要使用结尾的空格，使用结尾的反斜杠。

The [CommonMark spec](http://spec.commonmark.org/0.20/#hard-line-breaks) 规范规定一行末尾的两个空格应该插入“<br />”标记。
但是，许多目录都有一个尾随的空格预提交检查，而且许多ide都会清除它。
                                                                         
最佳实践是完全避免‘<br />’的需要。Markdown用换行符为您创建段落标记:适应它。

## 标题

### ATX-style 标题

```markdown
## Heading 2
```

带有' = '或' - '下划线的标题可能难以维护，并且与标题语法的其他部分不匹配。用户必须问:‘——’是指H1还是H2?

```markdown
标题-你还记得是什么级别吗?不要这样做。
---------
```

### 给标题增加间距

更喜欢' # '后的间距和换行前后:

```markdown
...text before.

# Heading 1

Text after...
```

缺乏间距使它有点难以阅读的来源:

```markdown
...text before.

#Heading 1
Text after... DO NOT DO THIS.
```

## 列表

### 对长列表使用惰性编号

Markdown非常聪明，可以让生成的HTML正确地呈现编号列表。对于可能改变的较长的列表，特别是嵌套的较长的列表，请使用“惰性”编号:

```markdown
1.  Foo.
1.  Bar.
    1.  Foofoo.
    1.  Barbar.
1.  Baz.
```

但是，如果列表很小，而且您不希望更改它，那么最好使用完全编号的列表，因为在源代码中阅读会更好:

```markdown
1.  Foo.
2.  Bar.
3.  Baz.
```

### 嵌套列表间距

嵌套列表时，对编号列表和项目符号列表使用4空格缩进:

```markdown
1.  2 spaces after a numbered list.
    4 space indent for wrapped text.
2.  2 spaces again.

*   3 spaces after a bullet.
    4 space indent for wrapped text.
    1.  2 spaces after a numbered list.
        8 space indent for the wrapped text of a nested list.
    2.  Looks nice, don't it?
*   3 spaces after a bullet.
```

下面的工作，但它很混乱:

```markdown
* One space,
with no indent for wrapped text.
     1. Irregular nesting... DO NOT DO THIS.
```

即使没有嵌套，使用4空格缩进使布局一致的包装文本:

```markdown
*   Foo,
    wrapped.

1.  2 spaces
    and 4 space indenting.
2.  2 spaces again.
```

然而，当列表很小，没有嵌套，只有一行时，一个空格就可以满足两种列表

```markdown
* Foo
* Bar
* Baz.

1. Foo.
2. Bar.
```

## Code

### Inline

&#96;Backticks&#96; 指定 `inline code`, 并将呈现所有包装的内容。使用它们作为简短的代码引用和字段名:

```markdown
You'll want to run `really_cool_script.sh arg`.

Pay attention to the `foo_bar_whammy` field in that table.
```

使用内联代码在抽象意义上引用文件类型，而不是一个特定的文件:

```markdown
Be sure to update your `README.md`!
```

反引号是最常见的“转义”标记元字符的方法;在大多数需要转义的情况下，代码字体是有意义的。

### Codeblocks

对于超过一行的代码引用，使用代码块:

<pre>
```python
def Foo(self, bar):
  self.bar = bar
```
</pre>

#### Declare the language

最佳实践是显式声明该语言，以便语法突出显示器和下一个编辑器都不必猜测。

#### Indented codeblocks are sometimes cleaner

四空格缩进也被解释为代码块。 这些看起来更清晰，并且在源代码中更易于阅读，但是无法指定语言。 
我们鼓励在编写许多简短摘要时使用它们：:

```markdown
You'll need to run:

    bazel run :thing -- --foo

And then:

    bazel run :another_thing -- --bar

And again:

    bazel run :yet_again -- --baz
```

#### Escape newlines

由于大多数命令行摘要都是直接复制并粘贴到终端中的，因此最佳做法是转义任何换行符。 在行尾使用单个反斜杠：

<pre>
```shell
bazel run :target -- --flag --foo=longlonglonglonglongvalue \
--bar=anotherlonglonglonglonglonglonglonglonglonglongvalue
```
</pre>

#### Nest codeblocks within lists

如果您需要列表中的代码块，请确保将其缩进以免破坏列表:

```markdown
*   Bullet.

    ```c++
    int foo;
    ```

*   Next bullet.
```

您还可以创建一个包含4个空格的嵌套代码块。 只需从列表缩进缩进4个额外的空格：

```markdown
*   Bullet.

        int foo;

*   Next bullet.
```

## 链接

长链接使源Markdown难以阅读并破坏了80个字符的换行。**尽可能缩短链接**.

### 使用信息丰富的Markdown链接标题

Markdown链接语法允许您设置链接标题，就像HTML一样。 明智地使用它。

将链接命名为“链接”或“此处”时，在快速扫描文档时不会告诉读者任何信息，这很浪费空间：

```markdown
See the syntax guide for more info: [link](syntax_guide.md).
Or, check out the style guide [here](style_guide.md).
DO NOT DO THIS.
```

取而代之的是自然地写出句子，然后返回并用链接包装最合适的短语：

```markdown
See the [syntax guide](syntax_guide.md) for more info.
Or, check out the [style guide](style_guide.md).
```

## Images

尽量少用图像，并且喜欢简单的屏幕截图。 本指南的设计思想是，纯文本使用户更快地从事交流业务，而减少读者的注意力和作者的拖延。 
但是，有时候对表明您的意思很有帮助。

See [image syntax](https://gerrit.googlesource.com/gitiles/+/master/Documentation/markdown.md#Images).

## Prefer lists to tables

Markdown中的任何表都应该很小。 复杂的大型表格很难从源代码中读取，而且最重要的是，**稍后再修改**。

```markdown
Fruit | Attribute | Notes
--- | --- | --- | ---
Apple | [Juicy](https://example.com/SomeReallyReallyReallyReallyReallyReallyReallyReallyLongQuery), Firm, Sweet | Apples keep doctors away.
Banana | [Convenient](https://example.com/SomeDifferentReallyReallyReallyReallyReallyReallyReallyReallyLongQuery), Soft, Sweet | Contrary to popular belief, most apes prefer mangoes.

DO NOT DO THIS
```

[链接](#lists) 和副标题通常足以以较小的紧凑性显示相同的信息，尽管它更易于编辑：

```markdown
## Fruits

### Apple

* [Juicy](https://SomeReallyReallyReallyReallyReallyReallyReallyReallyReallyReallyReallyReallyReallyReallyReallyReallyLongURL)
* Firm
* Sweet

Apples keep doctors away.

### Banana

* [Convenient](https://example.com/SomeDifferentReallyReallyReallyReallyReallyReallyReallyReallyLongQuery)
* Soft
* Sweet

Contrary to popular belief, most apes prefer mangoes.
```

但是，有时需要一个小表：

```markdown
Transport | Favored by | Advantages
--- | --- | ---
Swallow | Coconuts | Otherwise unladen
Bicycle | Miss Gulch | Weatherproof
X-34 landspeeder | Whiny farmboys | Cheap since the X-38 came out
```

## 强烈喜欢Markdown而不是HTML

请尽可能使用标准的Markdown语法，并避免HTML遭黑客入侵。 如果您似乎无法完成所需的工作，请重新考虑是否确实需要它。 
除了[big tables](#prefer-lists-to-tables)外，Markdown已经满足了几乎所有需求。

HTML或Javascript入侵的每一个细节都降低了可读性和可移植性，从而限制了与其他工具集成的有用性，
这些工具可能将源显示为纯文本或将其呈现。 
See [Philosophy](philosophy.md).

Gitiles does not render HTML.

## 扩展阅读

[Google的Markdown规范](https://github.com/google/styleguide/blob/gh-pages/docguide/style.md)



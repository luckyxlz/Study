# File

`java.io.File` 类是文件和目录路径名的抽象表示，主要用于文件和目录的创建、查找和删除等操作。

### 构造方法

- `public File(String pathname)` ：通过将给定的路径名字符串转换为抽象路径名来创建新的 File实例。
- `public File(String parent, String child)` ：从父路径名字符串和子路径名字符串创建新的 File实例。
- `public File(File parent, String child)` ：从父抽象路径名和子路径名字符串创建新的 File实例。



### 成员方法

#### 获取文件信息方法

- `public String getAbsolutePath()` ：返回此File的绝对路径名字符串。
- `public String getPath()` ：将此File转换为路径名字符串。
- `public String getName()` ：返回由此File表示的文件或目录的名称。
- `public long length()` ：返回由此File表示的文件的长度，如果是文件夹则返回0。

#### 判断文件的方法

- `public boolean exists()` ：此File表示的文件或目录是否实际存在。
- `public boolean isDirectory()` ：此File表示的是否为目录。
- `public boolean isFile()` ：此File表示的是否为文件。

#### 文件的创建与删除方法

- `public boolean createNewFile()` ：当且仅当具有该名称的文件尚不存在时，创建一个新的空文件。
- `public boolean delete()` ：删除由此File表示的文件或目录。
- `public boolean mkdir()` ：创建由此File表示的目录。
- `public boolean mkdirs()` ：创建由此File表示的目录，包括任何必需但不存在的父目录。

#### 文件的创建与删除方法

- `public boolean createNewFile()` ：当且仅当具有该名称的文件尚不存在时，创建一个新的空文件。
- `public boolean delete()` ：删除由此File表示的文件或目录。
- `public boolean mkdir()` ：创建由此File表示的目录。
- `public boolean mkdirs()` ：创建由此File表示的目录，包括任何必需但不存在的父目录。


# java IO
> 在创建一个结果流时，通常会组合多个对象来提供所需要的功能。(装饰器模式)

## 输入流种类
* 字节数组
* String
* 文件
* 管道
* 其他数据，网络连接等

## InputStream & OutputStream
```java
ByteArrayInputStream, BufferInputStream, FileInputStream, PipedINputStream, FilterInputStream
ByteArrayOutputStream, FileOutputStream, PipedOutputStream, FilterOutputStream
``` 

`FilterInputStream & FilterOutputStream` 用来提供装饰器类接口以及控制特定输入流和输出流的两个类.
FilterInputStream 的子类可以在内部修改 InputStream 的行为方式: 缓冲、保存行数、把单一字符推回输入流等
DataInputStream 允许读取不同的基本类型数据以及 String，所有方法都以 read 开头: readByte(), readString()
```java
DataInputStream, BufferedInputStream, LineNumberInputStream, PushbackInputStream
DataOUtputStream, BufferedOutputStream, PrintStream
```

### Reader & Writer
> 字符流支持 unicode 字符集. 组合 字节流 与 字符流 适配器类 `InputStreamReader & OutputStreamReader` 把输入流转化为 字节流.
  使用字节流与字符流的选择: 尽量使用字符流，其次字符流

字节流 | 字符流
--- | ---
InputStream,OutputStream | Reader,Writer (适配器: InputStreamReader,OutputStreamWriter) 
FileInputStream,FileOutputStream | FileReader,FileWriter
ByteArrayInputStream,ByteArrayOutputStream | CharArrayReader,CharArrayWriter
PipedInputStream,PipedOutputStream | PipedReader,PipedWriter
FilterInputStream,FilterOutputStream| FilterReader,FilterWriter
FileInputStream,FileOutputStream| FileReader,FileWriter
BufferedInputStream,BufferedOutputStream | BufferedReader, BufferedWriter
PrintStream | PrintWriter

  




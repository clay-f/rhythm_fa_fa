# java IO
> 在创建一个结果流时，通常会组合多个对象来提供所需要的功能。(装饰器模式)

流种类
1. 字节数组
2. String
3. 文件
4. 管道
5. 其他数据，网络连接等

### InputStream & OutputStream
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


## java NIO
> 通道和缓冲器. 与数据交互时，只和缓冲器交互，把缓冲器送到通道。从缓冲器中获取数据，或向缓冲器写入数据.
  唯一直接与通道交互的缓冲器是 `ByteBuffer`, 用于以原始的字节形式或基本数据类型输出和读取数据

#### 试图缓冲器
> 通过以特定的基本数据类型的视图查看底层的 `ByteBuffer`。 对视图的修改都会映射到对 `ByteBuffer` 的修改， 依旧是储存数据的地方，可以用户支持不同种类的视图
```java
   var data= ByteBuffer.allocate(1);
   data.asCharBuffer();
   data.asIntBuffer()
   // 把 ByteBuffer 转化为不同的视图
```


  




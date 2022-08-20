// // 写入流
// var fs = require("fs")

// //写入数据的变量
// var data = "hello world"

// //创建一个可写入流
// var writerStream = fs.createWriteStream("output.txt");

// //设置文件写入编码
// writerStream.write(data,"utf-8");

// writerStream.on("finish",function(){
//   console.log("文件写入完成")
// })
// console.log("程序执行完毕")





// //导入模块
// var fs = require("fs")

// //创建读取流
// var readerStream = fs.createReadStream("index.html")

// //创建写入流
// var writerStream = fs.createWriteStream("output.txt")

// readerStream.pipe(writerStream);

// console.log("程序执行完毕")




// //模块系统
// var hello = require("./test1")
// hello.world()

// 函数的使用
// function sayHello(say, value){
//   say(value);
// }
// function say(word){
//   console.log("Say " + word)
// }

// sayHello(say,"Hello")


// 匿名函数的使用
// function SayHello(say,value){
//   say(value);
// }

// SayHello(function(word){
//   console.log("Say "+ word)
// }, "Hello")

// var http = require('http');
// var querystring = require('querystring');
 
// var postHTML = 
//   '<html><head><meta charset="utf-8"><title>菜鸟教程 Node.js 实例</title></head>' +
//   '<body>' +
//   '<form method="post">' +
//   '网站名： <input name="name"><br>' +
//   '网站 URL： <input name="url"><br>' +
//   '<input type="submit">' +
//   '</form>' +
//   '</body></html>';
 
// http.createServer(function (req, res) {
//   var body = "";
//   req.on('data', function (chunk) {
//     body += chunk;
//   });
//   req.on('end', function () {
//     // 解析参数
//     body = querystring.parse(body);
//     // 设置响应头部信息及编码
//     res.writeHead(200, {'Content-Type': 'text/html; charset=utf8'});
 
//     if(body.name && body.url) { // 输出提交的数据
//         res.write("网站名：" + body.name);
//         res.write("<br>");
//         res.write("网站 URL：" + body.url);
//     } else {  // 输出表单
//         res.write(postHTML);
//     }
//     res.end();
//   });
// }).listen(3000);
var express = require("express")
var app = express();

app.use("/note",express.static("NOTE"));

app.get("/", function(req, res){
  res.send("Hello world")
})
app.listen(8080)
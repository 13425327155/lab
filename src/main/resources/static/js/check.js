// function Captcha(){
//     code = $("#code")
//     // 验证码组成库
//     var arrays=new Array(
//         '1','2','3','4','5','6','7','8','9','0',
//         'a','b','c','d','e','f','g','h','i','j',
//         'k','l','m','n','o','p','q','r','s','t',
//         'u','v','w','x','y','z',
//         'A','B','C','D','E','F','G','H','I','J',
//         'K','L','M','N','O','P','Q','R','S','T',
//         'U','V','W','X','Y','Z'
//     );
//     codes = '';
//     for (var i = 0; i <4; i++){
//         var range = parseInt(Math.random()*arrays.length);
//         codes = codes + arrays[range];
//     }
//     code.val(codes);
// }
// Captcha();
// code.click(Captcha);
// $("#check").click(function () {
//     var inputCode = $("#input").val().toUpperCase();
//     if(inputCode.length == 0) { //若输入的验证码长度为0
//         alert("请输入验证码！"); //则弹出请输入验证码
//         Captcha();//刷新验证码
//         return false;
//     }
//     else if(inputCode!=codes.toUpperCase()) { //若输入的验证码与产生的验证码不一致时
//         alert("验证码输入错误!请重新输入"); //则弹出验证码输入错误
//         Captcha();//刷新验证码
//         $("#input").val("");//清空文本框
//         return false;
//     }else { //输入正确时
//         alert("修改成功");
//         return true;
//     }
// });
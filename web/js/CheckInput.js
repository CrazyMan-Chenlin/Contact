function checkName(){
    var name=document.getElementById("name").value;
    var reg=/^[a-zA-Z\u4E00-\u9FA5]{2,14}$/; //js 正则表达式是以/开始和结束
    var nameTip=document.getElementById("nameTip");
    if (reg.test(name)){
        nameTip.innerHTML="名字正确".fontcolor("green");
        return true;
    }else {
        nameTip.innerHTML="名字有误".fontcolor("red");
        return false;
    }
}
function checkGender() {
    var status=false;
    var gender=document.getElementsByName("gender");
    var genderTip=document.getElementById("genderTip");
     for(var i=0;i<gender.length;i++){
         if(gender[i].checked){
             status=true
         }
     }
    if(status){
        genderTip.innerHTML="已填".fontcolor("green");
        return true;
         }else{
        return false;
         }
}
function checkAge() {
    var age=document.getElementById("age").value;
    var ageTip=document.getElementById("ageTip");
    var reg=/^[0-9]{1,2}$/
    if(reg.test(age)){
        ageTip.innerHTML="填写正确".fontcolor("green");
        return true;
    }else{
        ageTip.innerHTML="填写错误".fontcolor("red");
        return false;
    }
}
function  checkPhone() {
    var phone=document.getElementById("phone").value;
    var phoneTip=document.getElementById("phoneTip");
    var  reg=/^[0-9]{11}$/;
    if(reg.test(phone)){
        phoneTip.innerHTML="填写正确".fontcolor("green");
        return true;
    }else{
        phoneTip.innerHTML="填写错误".fontcolor("red");
        return false;
    }
}
 function checkMail() {
     var email=document.getElementById("email").value;
     var emailTip=document.getElementById("emailTip");
     var reg=/^[0-9A-Za-z]+@[0-9A-Za-z]+(\.[a-z]{2,3}){1,2}$/;
     if(reg.test(email)){
         emailTip.innerHTML="邮箱格式正确".fontcolor("green");
         return true;
     }else {
         emailTip.innerHTML="邮箱格式有误".fontcolor("red");
         return false;
     }
 }
  function checkQQ() {
      var QQ=document.getElementById("QQ").value;
      var QQTip=document.getElementById("QQTip")
      var reg=/^[0-9]{9,10}$/;
      if(reg.test(QQ)){
         QQTip.innerHTML="QQ格式正确".fontcolor("green");
          return true;
      }else {
          QQTip.innerHTML="QQ格式错误".fontcolor("red");
          return false;
      }
  }
  function checkAll() {
      if(checkGender()&&checkQQ()&&checkMail()&&checkPhone()&&checkAge()&&checkName()){
          return true;
      }else {
          return false;
      }
  }
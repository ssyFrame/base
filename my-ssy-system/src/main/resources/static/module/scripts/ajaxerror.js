$.ajax({
   url: "/frame/getAjax",
   type: "GET",
   async: false,
   success: function (data) {
       if (data.status == 200 && data.msg == "ok"){
           alert("success");
       } else {
           alert("发生异常" + data.msg);
       }
   },
   error: function (response, ajaxOptions, thrownError) {
       alert("error");
   }
});
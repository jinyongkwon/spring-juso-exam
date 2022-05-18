function init() {
    var url = location.href;
    var confmKey = "U01TX0FVVEgyMDIyMDUxODEyMzIyMjExMjU4MTQ=";
    var resultType = "4";
    var inputYn = $("#inputYn").val();
    if (inputYn != "Y") {
        document.form.confmKey.value = confmKey;
        document.form.returnUrl.value = url;
        document.form.resultType.value = resultType;
        document.form.action = "http://www.juso.go.kr/addrlink/addrLinkUrl.do";
        document.form.submit();
    } else {
        opener.jusoCallBack($("#roadFullAddr").val());
        window.close();
    }
}
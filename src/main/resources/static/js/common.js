function goPopup() {
    var pop = window.open("/juso", "pop", "width=570,height=420, scrollbars=yes, resizable=yes");
}

function jusoCallBack(roadFullAddr) {
    document.form.roadFullAddr.value = roadFullAddr;
}
$("#btn-update").click(() => {
    update();
})

$("#btn-delete").click(() => {
    deleteUser();
})

let deleteUser = async () => {
    let check = confirm("정말 회원을 탈퇴 하시겠습니까?? \n 주의 : 삭제가 성공하면 회원의 모든 정보가 삭제 됩니다.")
    if (check == true) {
        let userId = $("#userId").val();
        let response = await fetch(`/s/api/user/${userId}`, {
            method: "DELETE"
        })
        if (response.status == 200) {
            alert("회원을 삭제하였습니다");
            location.href = "/login-form"
        }
    }
}

let update = async () => {
    let userId = $("#userId").val();
    let updateDto = {
        email: $("#email").val(),
        address: $("#roadFullAddr").val()
    }
    let response = await fetch(`/s/api/user/${userId}`, {
        method: "PUT",
        headers: {
            "Content-Type": "application/json; charset=utf-8"
        },
        body: JSON.stringify(updateDto)
    })
    if (response.status == 200) {
        alert("회원정보를 수정하였습니다");
        location.href = "/s/update-form"
    }
}

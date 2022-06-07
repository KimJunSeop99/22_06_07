// axios 사용법
// ex) get방식 : axios.get('/user/12345')
//     post방식 : axios.post('/user',{id:'aa',name:'forbob'})
//    axios : get, post, put, delete
//    axios.post('/user,{id:'aa',name:'forbob'})
//    .then(function(res) {
//   성공하면 then 들어옴
//     })
//    .catch(function(error) {
//  실패하면 catch 들어옴
// })
import http from "../http-common";

// 자바스크립트 class
class CustomerDataService {
    // customers 전체 목록 조회 메소드
    // axios -> spring 데이터 요청 -> spring -> db -> 결과 반환
    // 모든 회원 조회
    getAll() {
        return http.get("/customers");
    }
    // id로 회원 조회하는 메소드
    get(id) {
        return http.get(`/customers/${id}`);
    }
    // customer 데이터 추가 메소드(insert 문 호출)
    create(data) {
        return http.post("/customers", data);
    }
    // customer 데이터 수정 메소드(update 문 호출)
    update(id, data) {
        return http.put(`/customers/${id}`, data);
    }
    // customer 데이터 삭제 메소드(update 문 호출)
    delete(id) {
        return http.put(`/customers/deletion/${id}`);
    }
}
// export : 모듈을 다른 자바스크립트 파일에서 참조함
// new 모듈명 : class 객체생성을 위해 new 사용함
export default new CustomerDataService();

<template>
    <div>
        <table class="table">
            <thead>
                <tr>
                    <th scope="col">First Name</th>
                    <th scope="col">Last Name</th>
                    <th scope="col">Email</th>
                    <th scope="col">Phone</th>
                    <th scope="col">Actions</th>
                </tr>
            </thead>
            <!-- 조회 데이터 생성 부분 -->
            <tbody v-for="(customer, index) in customers" :key="index">
                <tr>
                    <td>{{ customer.firstName }}</td>
                    <td>{{ customer.lastName }}</td>
                    <td>{{ customer.email }}</td>
                    <td>{{ customer.phone }}</td>
                    <td>
                        <a
                            :href="'/customer/' + customer.id"
                            class="btn btn-primary"
                            >Edit</a
                        >
                    </td>
                </tr>
            </tbody>
        </table>
    </div>
</template>

<script>
import CustomerDataService from "@/services/CustomerDataService";
/* eslint-disable */
export default {
    // 첫화면 : http://localhost:8080
    // 전체목록 화면 표시
    name: "customers",
    data() {
        //tutorials 객체, 변수들 초기화
        return {
            customers: [],
        };
    },
    methods: {
        // 모든 회원 조회 서비스 호출
        retrieveCustomers() {
            // axios로 spring에 모든 회원 조회 요청
            CustomerDataService.getAll()
                // 성공하면 then으로 서버 데이터(response.data)가 들어옴
                .then((response) => {
                    this.customers = response.data;
                })
                // 실패하면 catch로 에러메세지가 들어옴
                .catch((e) => {
                    alert(e);
                });
        },
    },
    // 최초 화면이 로딩될때(뜰때) 실행되는 이벤트(모든 회원조회가 실행됨)
    mounted() {
        this.retrieveCustomers();
    },
};
</script>

<style>
.list {
    text-align: left;
    max-width: 750px;
    margin: auto;
}
</style>

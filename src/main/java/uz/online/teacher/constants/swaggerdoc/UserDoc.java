package uz.online.teacher.constants.swaggerdoc;

public class UserDoc {

    public static final String GETONE_RESPONSE_SUCCESS = """
            {
                   "success": true,
                   "message": null,
                   "code": 0,
                   "errors": null,
                   "errorResponse": null,
                   "data": {
                       "id": 1,
                       "firstName": "Jaloliddin",
                       "lastName": "Jabborov",
                       "secondName": "Faxriddinovich",
                       "fullName": "Jabborov Jaloliddin Faxriddinovich",
                       "genderDto": {
                           "id": 1,
                           "name": "erkak"
                       },
                       "birthDate": "1992-06-20",
                       "pinfl": null,
                       "documentSerial": "AC",
                       "documentNumber": "3083665",
                       "addressDto": null,
                       "phone": "998937957093",
                       "email": "jabborovjaloliddin9@gmailcom",
                       "parentFullName": null,
                       "parentPhone": null,
                       "authorityDto": {
                           "id": 1,
                           "authority": "admin",
                           "name": "admin"
                       },
                       "subjectDtos": []
                   }
               }
            """;
    public static final String GETONE_RESPONSE_BADREQUEST = """
            {
                "success": false,
                "message": "",
                "code": 2,
                "errors": null,
                "errorResponse": {
                    "code": 1000,
                    "message": "User topilmadi: id = 2"
                },
                "data": null
            }
            """;
    public static final String GETLIST_RESPONSE_SUCCESS = """
            {
                    "success": true,
                    "message": null,
                    "code": 0,
                    "errors": null,
                    "errorResponse": null,
                    "data": {
                        "content": [
                            {
                                "id": 1,
                                "firstName": "Jaloliddin",
                                "lastName": "Jabborov",
                                "secondName": "Faxriddinovich",
                                "fullName": "Jabborov Jaloliddin Faxriddinovich",
                                "genderDto": {
                                    "id": 1,
                                    "name": "erkak"
                                },
                                "birthDate": "1992-06-20",
                                "pinfl": null,
                                "documentSerial": "AC",
                                "documentNumber": "3083665",
                                "addressDto": null,
                                "phone": "998937957093",
                                "email": "jabborovjaloliddin9@gmailcom",
                                "parentFullName": null,
                                "parentPhone": null,
                                "authorityDto": {
                                    "id": 1,
                                    "authority": "admin",
                                    "name": "admin"
                                },
                                "subjectDtos": []
                            }
                        ],
                        "pageable": {
                            "pageNumber": 0,
                            "pageSize": 1,
                            "sort": {
                                "empty": true,
                                "sorted": false,
                                "unsorted": true
                            },
                            "offset": 0,
                            "unpaged": false,
                            "paged": true
                        },
                        "last": false,
                        "totalElements": 2,
                        "totalPages": 2,
                        "size": 1,
                        "number": 0,
                        "sort": {
                            "empty": true,
                            "sorted": false,
                            "unsorted": true
                        },
                        "first": true,
                        "numberOfElements": 1,
                        "empty": false
                    }
                }
            """;
    public static final String GETLIST_RESPONSE_SUCCESS_EMPTY = """
            {
                "success": true,
                "message": null,
                "code": 0,
                "errors": null,
                "errorResponse": null,
                "data": []
            }
            """;
    public static final String CREATE_EXAMPLE = """
            {
                   "firstName": "Islomov",
                   "lastName": "Bahrom",
                   "secondName": "Samadovich",
                   "birthDate": "1999-01-04",
                   "genderId": 1,
                   "pinfl": "11111111111112",
                   "documentSerial": "AA",
                   "documentNumber": "1234567",
                   "username": "test22",
                   "password": "test",
                   "phone": "998937957083",
                   "email": "test22@gmail.com",
                   "parentFullName": "test",
                   "parentPhone": "998937957094",
                   "authorityId": 1,
                   "addressId": null,
                   "subjectIds": [1],
                   "addressForm": {
                       "regionId": 1,
                       "districtId": 1,
                       "address": "test2"
                   }
               }
            """;
    public static final String CREATE_RESPONSE_SUCCESS = """
            {
                      "success": true,
                      "message": null,
                      "code": 0,
                      "errors": null,
                      "errorResponse": null,
                      "data": {
                          "id": 1,
                          "firstName": "Jaloliddin",
                          "lastName": "Jabborov",
                          "secondName": "Faxriddinovich",
                          "fullName": "Jabborov Jaloliddin Faxriddinovich",
                          "genderDto": {
                              "id": 1,
                              "name": "erkak"
                          },
                          "birthDate": "1992-06-20",
                          "pinfl": null,
                          "documentSerial": "AC",
                          "documentNumber": "3083665",
                          "addressDto": null,
                          "phone": "998937957093",
                          "email": "jabborovjaloliddin9@gmailcom",
                          "parentFullName": null,
                          "parentPhone": null,
                          "authorityDto": {
                              "id": 1,
                              "authority": "admin",
                              "name": "admin"
                          },
                          "subjectDtos": []
                      }
                  }
            """;
    public static final String CREATE_RESPONSE_BADREQUEST_EXCEPTION = """
            {
                 "success": false,
                 "message": "",
                 "code": 2,
                 "errors": null,
                 "errorResponse": {
                     "code": 1007,
                     "message": "998937957093 maydonli phone mavjud"
                 },
                 "data": null
             }
            """;
    public static final String CREATE_RESPONSE_BADREQUEST_ERROR = """
            {
                "success": false,
                "message": "Validation error",
                "code": 1,
                "errors": [
                    {
                        "field": "documentSerial",
                        "message": "namuna bo`yicha kiritlmagan"
                    },
                    {
                        "field": "parentPhone",
                        "message": "namuna bo`yicha kiritlmagan"
                    },
                    {
                        "field": "documentNumber",
                        "message": "namuna bo`yicha kiritlmagan"
                    },
                    {
                        "field": "email",
                        "message": "email noto`g`ri: email"
                    }
                ],
                "errorResponse": null,
                "data": null
            }
            """;
    public static final String UPDATE_EXAMPLE = """
             {
                   "firstName": "Islomov",
                   "lastName": "Bahrom",
                   "secondName": "Samadovich",
                   "birthDate": "1999-01-04",
                   "genderId": 1,
                   "pinfl": "11111111111112",
                   "documentSerial": "AA",
                   "documentNumber": "1234567",
                   "username": "test22",
                   "password": "test",
                   "phone": "998937957083",
                   "email": "test22@gmail.com",
                   "parentFullName": "test",
                   "parentPhone": "998937957094",
                   "authorityId": 1,
                   "addressId": null,
                   "subjectIds": [1],
                   "addressForm": {
                       "regionId": 1,
                       "districtId": 1,
                       "address": "test2"
                   }
               }
            """;
    public static final String UPDATE_RESPONSE_SUCCESS = """
            {
                      "success": true,
                      "message": null,
                      "code": 0,
                      "errors": null,
                      "errorResponse": null,
                      "data": {
                          "id": 1,
                          "firstName": "Jaloliddin",
                          "lastName": "Jabborov",
                          "secondName": "Faxriddinovich",
                          "fullName": "Jabborov Jaloliddin Faxriddinovich",
                          "genderDto": {
                              "id": 1,
                              "name": "erkak"
                          },
                          "birthDate": "1992-06-20",
                          "pinfl": null,
                          "documentSerial": "AC",
                          "documentNumber": "3083665",
                          "addressDto": null,
                          "phone": "998937957093",
                          "email": "jabborovjaloliddin9@gmailcom",
                          "parentFullName": null,
                          "parentPhone": null,
                          "authorityDto": {
                              "id": 1,
                              "authority": "admin",
                              "name": "admin"
                          },
                          "subjectDtos": []
                      }
                  }
            """;
    public static final String UPDATE_RESPONSE_BADREQUEST = """
            {
                "success": false,
                "message": "",
                "code": 2,
                "errors": null,
                "errorResponse": {
                    "code": 1000,
                    "message": "User topilmadi: id = 1"
                },
                "data": null
            }
            """;
    public static final String DELETE_RESPONSE_BADREQUEST = """
            {
                "success": false,
                "message": "",
                "code": 2,
                "errors": null,
                "errorResponse": {
                    "code": 1000,
                    "message": "User topilmadi: id = 1"
                },
                "data": null
            }
            """;
}

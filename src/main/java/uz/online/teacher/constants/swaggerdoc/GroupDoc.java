package uz.online.teacher.constants.swaggerdoc;

public class GroupDoc {

    public static final String GETONE_RESPONSE_SUCCESS = """
            {
                  "success": true,
                  "message": null,
                  "code": 0,
                  "errors": null,
                  "errorResponse": null,
                  "data": {
                      "id": 8,
                      "name": "test",
                      "orderNumber": 1,
                      "subjectDto": {
                          "id": 2,
                          "name": "Fizika",
                          "subjectTypeDto": {
                              "id": 1,
                              "name": "Nazariy"
                          }
                      },
                      "startDate": "10.11.2023",
                      "endDate": null,
                      "teacherDto": {
                          "id": 1,
                          "firstName": "Jaloliddin",
                          "lastName": "Jabborov",
                          "secondName": "Faxriddinovich",
                          "fullName": "Jabborov Jaloliddin Faxriddinovich",
                          "genderDto": {
                              "id": 1,
                              "name": "erkak"
                          },
                          "birthDate": "20.06.1992",
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
                              "authority": "ADMIN",
                              "name": "admin"
                          },
                          "subjectDtos": []
                      },
                      "schoolYearDto": {
                          "id": 1,
                          "name": "2023-2024",
                          "startDate": "02.09.2023",
                          "endDate": "08.07.2026"
                      },
                      "active": false
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
                    "message": "Region topilmadi: id = 2"
                },
                "data": null
            }
            """;
    public static final String GETALL_RESPONSE_SUCCESS = """
            {
                   "success": true,
                   "message": null,
                   "code": 0,
                   "errors": null,
                   "errorResponse": null,
                   "data": [
                       {
                           "id": 1,
                           "name": "test",
                           "orderNumber": null,
                           "subjectDto": {
                               "id": 2,
                               "name": "Fizika",
                               "subjectTypeDto": {
                                   "id": 1,
                                   "name": "Nazariy"
                               }
                           },
                           "startDate": "01.01.2023",
                           "endDate": "01.01.2023",
                           "teacherDto": {
                               "id": 1,
                               "firstName": "Jaloliddin",
                               "lastName": "Jabborov",
                               "secondName": "Faxriddinovich",
                               "fullName": "Jabborov Jaloliddin Faxriddinovich",
                               "genderDto": {
                                   "id": 1,
                                   "name": "erkak"
                               },
                               "birthDate": "20.06.1992",
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
                                   "authority": "ADMIN",
                                   "name": "admin"
                               },
                               "subjectDtos": []
                           },
                           "schoolYearDto": {
                               "id": 1,
                               "name": "2023-2024",
                               "startDate": "02.09.2023",
                               "endDate": "08.07.2026"
                           },
                           "active": false
                       },
                       {
                           "id": 2,
                           "name": "test",
                           "orderNumber": null,
                           "subjectDto": {
                               "id": 2,
                               "name": "Fizika",
                               "subjectTypeDto": {
                                   "id": 1,
                                   "name": "Nazariy"
                               }
                           },
                           "startDate": "01.01.2023",
                           "endDate": "01.01.2023",
                           "teacherDto": {
                               "id": 1,
                               "firstName": "Jaloliddin",
                               "lastName": "Jabborov",
                               "secondName": "Faxriddinovich",
                               "fullName": "Jabborov Jaloliddin Faxriddinovich",
                               "genderDto": {
                                   "id": 1,
                                   "name": "erkak"
                               },
                               "birthDate": "20.06.1992",
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
                                   "authority": "ADMIN",
                                   "name": "admin"
                               },
                               "subjectDtos": []
                           },
                           "schoolYearDto": {
                               "id": 1,
                               "name": "2023-2024",
                               "startDate": "02.09.2023",
                               "endDate": "08.07.2026"
                           },
                           "active": false
                       }
                   ]
               }
            """;
    public static final String GETALL_RESPONSE_SUCCESS_EMPTY = """
            {
                "success": true,
                "message": null,
                "code": 0,
                "errors": null,
                "errorResponse": null,
                "data": []
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
                             "name": "test",
                             "orderNumber": null,
                             "subjectDto": {
                                 "id": 2,
                                 "name": "Fizika",
                                 "subjectTypeDto": {
                                     "id": 1,
                                     "name": "Nazariy"
                                 }
                             },
                             "startDate": "01.01.2023",
                             "endDate": "01.01.2023",
                             "teacherDto": {
                                 "id": 1,
                                 "firstName": "Jaloliddin",
                                 "lastName": "Jabborov",
                                 "secondName": "Faxriddinovich",
                                 "fullName": "Jabborov Jaloliddin Faxriddinovich",
                                 "genderDto": {
                                     "id": 1,
                                     "name": "erkak"
                                 },
                                 "birthDate": "20.06.1992",
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
                                     "authority": "ADMIN",
                                     "name": "admin"
                                 },
                                 "subjectDtos": []
                             },
                             "schoolYearDto": {
                                 "id": 1,
                                 "name": "2023-2024",
                                 "startDate": "02.09.2023",
                                 "endDate": "08.07.2026"
                             },
                             "active": false
                         },
                         {
                             "id": 2,
                             "name": "test",
                             "orderNumber": null,
                             "subjectDto": {
                                 "id": 2,
                                 "name": "Fizika",
                                 "subjectTypeDto": {
                                     "id": 1,
                                     "name": "Nazariy"
                                 }
                             },
                             "startDate": "01.01.2023",
                             "endDate": "01.01.2023",
                             "teacherDto": {
                                 "id": 1,
                                 "firstName": "Jaloliddin",
                                 "lastName": "Jabborov",
                                 "secondName": "Faxriddinovich",
                                 "fullName": "Jabborov Jaloliddin Faxriddinovich",
                                 "genderDto": {
                                     "id": 1,
                                     "name": "erkak"
                                 },
                                 "birthDate": "20.06.1992",
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
                                     "authority": "ADMIN",
                                     "name": "admin"
                                 },
                                 "subjectDtos": []
                             },
                             "schoolYearDto": {
                                 "id": 1,
                                 "name": "2023-2024",
                                 "startDate": "02.09.2023",
                                 "endDate": "08.07.2026"
                             },
                             "active": false
                         }
                     ],
                     "pageable": {
                         "pageNumber": 0,
                         "pageSize": 5,
                         "sort": {
                             "empty": true,
                             "sorted": false,
                             "unsorted": true
                         },
                         "offset": 0,
                         "paged": true,
                         "unpaged": false
                     },
                     "last": true,
                     "totalPages": 1,
                     "totalElements": 2,
                     "size": 5,
                     "number": 0,
                     "sort": {
                         "empty": true,
                         "sorted": false,
                         "unsorted": true
                     },
                     "first": true,
                     "numberOfElements": 2,
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
                  "name": "test",
                  "orderNumber": 1,
                  "subjectId": 2,
                  "startDate": "",
                  "endDate": "",
                  "teacherId": 1,
                  "isActive": true
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
                     "id": 8,
                     "name": "test",
                     "orderNumber": 1,
                     "subjectDto": {
                         "id": 2,
                         "name": "Fizika",
                         "subjectTypeDto": {
                             "id": 1,
                             "name": "Nazariy"
                         }
                     },
                     "startDate": "10.11.2023",
                     "endDate": null,
                     "teacherDto": {
                         "id": 1,
                         "firstName": "Jaloliddin",
                         "lastName": "Jabborov",
                         "secondName": "Faxriddinovich",
                         "fullName": "Jabborov Jaloliddin Faxriddinovich",
                         "genderDto": {
                             "id": 1,
                             "name": "erkak"
                         },
                         "birthDate": "20.06.1992",
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
                             "authority": "ADMIN",
                             "name": "admin"
                         },
                         "subjectDtos": []
                     },
                     "schoolYearDto": {
                         "id": 1,
                         "name": "2023-2024",
                         "startDate": "02.09.2023",
                         "endDate": "08.07.2026"
                     },
                     "active": false
                 }
             }
            """;
    public static final String CREATE_RESPONSE_BADREQUEST = """
            {
                "success": false,
                "message": "",
                "code": 2,
                "errors": null,
                "errorResponse": {
                    "code": 111,
                    "message": "class java.lang.String cannot be cast to class uz.online.teacher.entity.User (java.lang.String is in module java.base of loader 'bootstrap'; uz.online.teacher.entity.User is in unnamed module of loader org.springframework.boot.devtools.restart.classloader.RestartClassLoader @167d79bb)"
                },
                "data": null
            }
            """;
    public static final String UPDATE_EXAMPLE = """
            {
                  "name": "test",
                  "orderNumber": 1,
                  "subjectId": 2,
                  "startDate": "",
                  "endDate": "",
                  "teacherId": 1,
                  "isActive": true
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
                      "id": 8,
                      "name": "test",
                      "orderNumber": 1,
                      "subjectDto": {
                          "id": 2,
                          "name": "Fizika",
                          "subjectTypeDto": {
                              "id": 1,
                              "name": "Nazariy"
                          }
                      },
                      "startDate": "10.11.2023",
                      "endDate": null,
                      "teacherDto": {
                          "id": 1,
                          "firstName": "Jaloliddin",
                          "lastName": "Jabborov",
                          "secondName": "Faxriddinovich",
                          "fullName": "Jabborov Jaloliddin Faxriddinovich",
                          "genderDto": {
                              "id": 1,
                              "name": "erkak"
                          },
                          "birthDate": "20.06.1992",
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
                              "authority": "ADMIN",
                              "name": "admin"
                          },
                          "subjectDtos": []
                      },
                      "schoolYearDto": {
                          "id": 1,
                          "name": "2023-2024",
                          "startDate": "02.09.2023",
                          "endDate": "08.07.2026"
                      },
                      "active": false
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
                    "code": 111,
                    "message": "class java.lang.String cannot be cast to class uz.online.teacher.entity.User (java.lang.String is in module java.base of loader 'bootstrap'; uz.online.teacher.entity.User is in unnamed module of loader org.springframework.boot.devtools.restart.classloader.RestartClassLoader @167d79bb)"
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
                    "message": "District topilmadi: id = 1"
                },
                "data": null
            }
            """;
}

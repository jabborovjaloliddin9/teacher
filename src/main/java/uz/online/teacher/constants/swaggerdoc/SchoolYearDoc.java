package uz.online.teacher.constants.swaggerdoc;

public class SchoolYearDoc {

    public static final String GETONE_RESPONSE_SUCCESS = """
            {
                 "success": true,
                 "message": null,
                 "code": 0,
                 "errors": null,
                 "errorResponse": null,
                 "data": {
                     "id": 1,
                     "name": "2023-2024",
                     "startDate": "01.09.2023",
                     "endDate": "31.08.2024"
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
                    "message": "SchoolYear topilmadi: id = 2"
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
                        "name": "2023-2024",
                        "startDate": "01.09.2023",
                        "endDate": "31.08.2024"
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
                            "name": "2023-2024",
                            "startDate": "01.09.2023",
                            "endDate": "31.08.2024"
                        }
                    ],
                    "pageable": {
                        "pageNumber": 0,
                        "pageSize": 5,
                        "sort": {
                            "empty": true,
                            "unsorted": true,
                            "sorted": false
                        },
                        "offset": 0,
                        "paged": true,
                        "unpaged": false
                    },
                    "last": true,
                    "totalPages": 1,
                    "totalElements": 1,
                    "size": 5,
                    "number": 0,
                    "sort": {
                        "empty": true,
                        "unsorted": true,
                        "sorted": false
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
                 "name": "2023-2024",
                 "startDate": "2023-09-01",
                 "endDate": "2024-08-31"
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
                       "name": "2023-2024",
                       "startDate": "01.09.2023",
                       "endDate": "31.08.2024"
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
                   "name": "2023-2024",
                   "startDate": "2023-09-01",
                   "endDate": "2024-08-31"
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
                      "name": "2023-2024",
                      "startDate": "01.09.2023",
                      "endDate": "31.08.2024"
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
                    "message": "SchoolYear topilmadi: id = 1"
                },
                "data": null
            }
            """;
}

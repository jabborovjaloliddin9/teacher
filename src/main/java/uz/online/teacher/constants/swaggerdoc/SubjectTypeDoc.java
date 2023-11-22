package uz.online.teacher.constants.swaggerdoc;

public class SubjectTypeDoc {

    public static final String GETONE_RESPONSE_SUCCESS = """
            {
                  "success": true,
                  "message": null,
                  "code": 0,
                  "errors": null,
                  "errorResponse": null,
                  "data": {
                      "id": 1,
                      "name": "Nazariy"
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
                    "message": "SubjectType topilmadi: id = 2"
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
                        "name": "Nazariy"
                    },
                    {
                        "id": 2,
                        "name": "Amaliy"
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
                            "name": "Nazariy"
                        },
                        {
                            "id": 2,
                            "name": "Amaliy"
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
                    "totalElements": 2,
                    "totalPages": 1,
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
                "name": {
                    "uz": "test",
                    "ru": "test",
                    "en": "test"
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
                      "name": "Nazariy"
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
                "shortName": {
                    "uz": "Tosh",
                    "ru": "Таш",
                    "en": "Tash"
                },
                "fullName": {
                    "uz": "Toshkent",
                    "ru": "Ташкент",
                    "en": "Tashkent"
                }
            }
            """;
    public static final String UPDATE_RESPONSE_SUCCESS = """
            {
                "name": {
                    "uz": "test",
                    "ru": "test",
                    "en": "test"
                }
            }
            """;
    public static final String UPDATE_RESPONSE_BADREQUEST = """
             {
                  "success": true,
                  "message": null,
                  "code": 0,
                  "errors": null,
                  "errorResponse": null,
                  "data": {
                      "id": 1,
                      "name": "Nazariy"
                  }
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
                    "message": "SubjectType topilmadi: id = 1"
                },
                "data": null
            }
            """;
}

package uz.online.teacher.constants.swaggerdoc;

public class RegionDoc {

    public static final String GETONE_RESPONSE_SUCCESS = """
            {
                  "success": true,
                  "message": null,
                  "code": 0,
                  "errors": null,
                  "errorResponse": null,
                  "data": {
                      "id": 2,
                      "name": "Sirdaryo"
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
                         "name": "Tosh"
                     },
                     {
                         "id": 2,
                         "name": "Tosh" 
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
                            "name": "Toshkent shahri"
                        },
                        {
                            "id": 2,
                            "name": "Sirdaryo"
                        },
                        {
                            "id": 3,
                            "name": "Jizzax"
                        },
                        {
                            "id": 4,
                            "name": "Samarqand"
                        },
                        {
                            "id": 5,
                            "name": "Qashqadaryo"
                        }
                    ],
                    "pageable": {
                        "pageNumber": 0,
                        "pageSize": 5,
                        "sort": {
                            "sorted": false,
                            "unsorted": true,
                            "empty": true
                        },
                        "offset": 0,
                        "paged": true,
                        "unpaged": false
                    },
                    "totalPages": 3,
                    "totalElements": 15,
                    "last": false,
                    "size": 5,
                    "number": 0,
                    "sort": {
                        "sorted": false,
                        "unsorted": true,
                        "empty": true
                    },
                    "first": true,
                    "numberOfElements": 5,
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
                    "uz": "Tosh",
                    "ru": "Таш",
                    "en": "Tash"
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
                       "id": 2,
                       "name": "Sirdaryo"
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
                "name": {
                    "uz": "Tosh",
                    "ru": "Таш",
                    "en": "Tash"
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
                      "id": 2,
                      "name": "Sirdaryo"
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

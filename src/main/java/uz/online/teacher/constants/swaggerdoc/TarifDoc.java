package uz.online.teacher.constants.swaggerdoc;

public class TarifDoc {

    public static final String GETONE_RESPONSE_SUCCESS = """
            {
                "success": true,
                "message": null,
                "code": 0,
                "errors": null,
                "errorResponse": null,
                "data": {
                    "id": 1,
                    "name": "Kunlik"
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
                    "message": "Tarif topilmadi: id = 2"
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
                          "name": "Kunlik"
                      },
                      {
                          "id": 2,
                          "name": "Oylik"
                      },
                      {
                          "id": 3,
                          "name": "Olti oylik"
                      },
                      {
                          "id": 4,
                          "name": "Yillik"
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
                             "name": "Kunlik"
                         },
                         {
                             "id": 2,
                             "name": "Oylik"
                         },
                         {
                             "id": 3,
                             "name": "Olti oylik"
                         },
                         {
                             "id": 4,
                             "name": "Yillik"
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
                     "totalElements": 4,
                     "totalPages": 1,
                     "first": true,
                     "numberOfElements": 4,
                     "size": 5,
                     "number": 0,
                     "sort": {
                         "empty": true,
                         "sorted": false,
                         "unsorted": true
                     },
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
                    "name": "Kunlik"
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
                      "uz": "test",
                      "ru": "test",
                      "en": "test"
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
                    "name": "Kunlik"
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

package uz.online.teacher.constants.swaggerdoc;

public class PreviligeDoc {

    public static final String GETONE_RESPONSE_SUCCESS = """
            {
                "success": true,
                "message": null,
                "code": 0,
                "errors": null,
                "errorResponse": null,
                "data": {
                    "id": 1,
                    "previlige": "write",
                    "name": "yozish"
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
                    "message": "Previlige topilmadi: id = 4"
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
                        "previlige": "write",
                        "name": "yozish"
                    },
                    {
                        "id": 2,
                        "previlige": "read",
                        "name": "o`qish"
                    },
                    {
                        "id": 3,
                        "previlige": "delete",
                        "name": "o`chirish"
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
                             "previlige": "write",
                             "name": "yozish"
                         },
                         {
                             "id": 2,
                             "previlige": "read",
                             "name": "o`qish"
                         },
                         {
                             "id": 3,
                             "previlige": "delete",
                             "name": "o`chirish"
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
                     "totalElements": 3,
                     "size": 5,
                     "number": 0,
                     "sort": {
                         "empty": true,
                         "sorted": false,
                         "unsorted": true
                     },
                     "first": true,
                     "numberOfElements": 3,
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
                  "previlige": "test",
                  "name": {
                      "uz": "test_uz",
                      "ru": "test_ru",
                      "en": "test_en"
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
                    "id": 4,
                    "previlige": "test",
                    "name": "test_uz"
                }
            }
            """;
    public static final String CREATE_RESPONSE_BADREQUEST = """
           {
                "success": true,
                "message": null,
                "code": 0,
                "errors": null,
                "errorResponse": null,
                "data": {
                    "id": 4,
                    "previlige": "test",
                    "name": "test_uz"
                }
            }
            """;
    public static final String UPDATE_EXAMPLE = """
            {
                  "previlige": "test",
                  "name": {
                      "uz": "test_uz",
                      "ru": "test_ru",
                      "en": "test_en"
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
                    "id": 4,
                    "previlige": "test",
                    "name": "test_uz"
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
                    "id": 4,
                    "previlige": "test",
                    "name": "test_uz"
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
                    "message": "Previlige topilmadi: id = 10"
                },
                "data": null
            }
            """;
}

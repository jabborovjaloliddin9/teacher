package uz.online.teacher.constants.swaggerdoc;

public class DistrictDoc {

    public static final String GETONE_RESPONSE_SUCCESS = """
            {
                "success": true,
                "message": null,
                "code": 0,
                "errors": null,
                "errorResponse": null,
                "data": {
                    "id": 1,
                    "name": "Chilonzor",
                    "regionDto": {
                        "id": 1,
                        "shortName": "Tosh",
                        "fullName": "Toshkent"
                    }
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
                    "message": "District topilmadi: id = 2"
                },
                "data": null
            }
            """;
    public static final String GETDALL_RESPONSE_SUCCESS = """
            {
                  "success": true,
                  "message": null,
                  "code": 0,
                  "errors": null,
                  "errorResponse": null,
                  "data": [
                      {
                          "id": 1,
                          "name": "Chilonzor"
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
    public static final String GETDLIST_RESPONSE_SUCCESS = """
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
                               "name": "Chilonzor",
                               "regionDto": {
                                   "id": 1,
                                   "name": "Toshkent shahri"
                               }
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
                       "totalElements": 1,
                       "totalPages": 1,
                       "size": 5,
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
                 "name": {
                     "uz": "Chilonzor",
                     "ru": "Чилонзор",
                     "en": "Chilonzor"
                 },
                 "regionId": 1
             }
            """;
    public static final String CREATE_RESPONSE_SUCCESS = """
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
    public static final String CREATE_RESPONSE_BADREQUEST = """
            {
                "success": true,
                "message": null,
                "code": 0,
                "errors": null,
                "errorResponse": null,
                "data": {
                    "id": 1,
                    "name": "Chilonzor",
                    "regionDto": {
                        "id": 1,
                        "shortName": "Tosh",
                        "fullName": "Toshkent"
                    }
                }
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
                "success": true,
                "message": null,
                "code": 0,
                "errors": null,
                "errorResponse": null,
                "data": {
                    "id": 1,
                    "name": "Chilonzor",
                    "regionDto": {
                        "id": 1,
                        "shortName": "Tosh",
                        "fullName": "Toshkent"
                    }
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
                    "message": "District topilmadi: id = 1"
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

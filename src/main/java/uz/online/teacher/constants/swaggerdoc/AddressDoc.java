package uz.online.teacher.constants.swaggerdoc;

public class AddressDoc {

    public static final String GETONE_RESPONSE_SUCCESS = """
            {
                 "success": true,
                 "message": null,
                 "code": 0,
                 "errors": null,
                 "errorResponse": null,
                 "data": {
                     "id": 1,
                     "regionDto": {
                         "id": 1,
                         "name": "Toshkent shahri"
                     },
                     "districtDto": {
                         "id": 1,
                         "name": "Chilonzor",
                         "regionDto": {
                             "id": 1,
                             "name": "Toshkent shahri"
                         }
                     },
                     "address": "test"
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
                    "message": "Address topilmadi: id = 2"
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
                               "id": 3,
                               "regionDto": {
                                   "id": 1,
                                   "name": "Toshkent shahri"
                               },
                               "districtDto": {
                                   "id": 1,
                                   "name": "Chilonzor",
                                   "regionDto": {
                                       "id": 1,
                                       "name": "Toshkent shahri"
                                   }
                               },
                               "address": "test2"
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
                  "regionId": 1,
                  "districtId": 1,
                  "address": "test"
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
                    "regionDto": {
                        "id": 1,
                        "name": "Toshkent shahri"
                    },
                    "districtDto": {
                        "id": 1,
                        "name": "Chilonzor",
                        "regionDto": {
                            "id": 1,
                            "name": "Toshkent shahri"
                        }
                    },
                    "address": "test"
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
                    "code": 1000,
                    "message": "district topilmadi: id = 2"
                },
                "data": null
            }
            """;
    public static final String UPDATE_EXAMPLE = """
            {
                  "regionId": 1,
                  "districtId": 1,
                  "address": "test"
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
                      "regionDto": {
                          "id": 1,
                          "name": "Toshkent shahri"
                      },
                      "districtDto": {
                          "id": 1,
                          "name": "Chilonzor",
                          "regionDto": {
                              "id": 1,
                              "name": "Toshkent shahri"
                          }
                      },
                      "address": "test"
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
                    "message": "Address topilmadi: id = 2"
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
                    "message": "Address topilmadi: id = 2"
                },
                "data": null
            }
            """;
}

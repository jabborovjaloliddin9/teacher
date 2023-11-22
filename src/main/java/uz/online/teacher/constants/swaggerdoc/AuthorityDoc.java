package uz.online.teacher.constants.swaggerdoc;

public class AuthorityDoc {

    public static final String GETONE_RESPONSE_SUCCESS = """
            {
                 "success": true,
                 "message": null,
                 "code": 0,
                 "errors": null,
                 "errorResponse": null,
                 "data": {
                     "id": 1,
                     "authority": "admin",
                     "name": "admin",
                     "previliges": [
                         {
                             "id": 2,
                             "previlige": "read",
                             "name": "o`qish"
                         },
                         {
                             "id": 1,
                             "previlige": "write",
                             "name": "yozish"
                         },
                         {
                             "id": 3,
                             "previlige": "delete",
                             "name": "o`chirish"
                         }
                     ]
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
                    "message": "Authority topilmadi: id = 2"
                },
                "data": null
            }
            """;
    public static final String FINDALL_RESPONSE_SUCCESS = """
            {
                "success": true,
                "message": null,
                "code": 0,
                "errors": null,
                "errorResponse": null,
                "data": [
                    {
                        "id": 1,
                        "authority": "admin",
                        "name": "admin",
                        "previliges": [
                            {
                                "id": 2,
                                "previlige": "read",
                                "name": "o`qish"
                            },
                            {
                                "id": 1,
                                "previlige": "write",
                                "name": "yozish"
                            },
                            {
                                "id": 3,
                                "previlige": "delete",
                                "name": "o`chirish"
                            }
                        ]
                    }
                ]
            }
            """;
    public static final String FINDALL_RESPONSE_SUCCESS_EMPTY = """
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
                              "authority": "admin",
                              "name": "admin",
                              "previliges": [
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
                          },
                          {
                              "id": 2,
                              "authority": "test",
                              "name": "test_uz",
                              "previliges": [
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
                          },
                          {
                              "id": 4,
                              "authority": "test2",
                              "name": "test_uz",
                              "previliges": [
                                  {
                                      "id": 1,
                                      "previlige": "write",
                                      "name": "yozish"
                                  },
                                  {
                                      "id": 2,
                                      "previlige": "read",
                                      "name": "o`qish"
                                  }
                              ]
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
                      "totalElements": 3,
                      "totalPages": 1,
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
                   "authority":"test",
                   "name": {
                       "uz": "test_uz",
                       "ru": "test_ru",
                       "en": "test_en"
                   },
                   "previliges": [1, 2, 3]
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
                    "authority": "test",
                    "name": "test_uz",
                    "previliges": [
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
            }
            """;
    public static final String CREATE_RESPONSE_BADREQUEST = """
            {
                 "success": false,
                 "message": "",
                 "code": 2,
                 "errors": null,
                 "errorResponse": {
                     "code": 1007,
                     "message": "test2 maydonli authority mavjud"
                 },
                 "data": null
             }
            """;
    public static final String UPDATE_EXAMPLE = """
            {
                   "authority":"test",
                   "name": {
                       "uz": "test_uz",
                       "ru": "test_ru",
                       "en": "test_en"
                   },
                   "previliges": [1, 2, 3]
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
                    "authority": "test",
                    "name": "test_uz",
                    "previliges": [
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
                    "message": "Authority topilmadi: id = 2"
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
    public static final String SIGN_IN_EXAMPLE = """
            {
                "username": "jaloliddin9",
                "password": "jshkm92952023"
            }
            """;
    public static final String SIGN_IN_RESPONSE_SUCCESS = """
            {
                "success": true,
                "message": null,
                "code": 0,
                "errors": null,
                "errorResponse": null,
                "data": {
                    "accessToken": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIyOTVkMTdjYi1iNTZkLTQ5MGEtYTUxOS1mYzMzNzUxODE3NzgiLCJleHAiOjE2OTkzMDMxNzR9.y_27lw2_xYzjng8bG3_RKD08q_XaD13mmXOVr3x4MvU",
                    "refreshToken": "21564d99-175a-4f70-8bbf-931fadc89e24"
                }
            }
            """;
    public static final String SIGN_IN_RESPONSE_BAD_REQUEST = """
            {
                "success": false,
                "message": "",
                "code": 2,
                "errors": null,
                "errorResponse": {
                    "code": 1004,
                    "message": "login yoki parol noto`g`ri"
                },
                "data": null
            }
            """;
    public static final String REFRESH_TOKEN_RESPONSE_SUCCESS = """
            {
                "success": true,
                "message": null,
                "code": 0,
                "errors": null,
                "errorResponse": null,
                "data": {
                    "accessToken": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIyOTVkMTdjYi1iNTZkLTQ5MGEtYTUxOS1mYzMzNzUxODE3NzgiLCJleHAiOjE2OTkzMDMxNzR9.y_27lw2_xYzjng8bG3_RKD08q_XaD13mmXOVr3x4MvU",
                    "refreshToken": "21564d99-175a-4f70-8bbf-931fadc89e24"
                }
            }
            """;
    public static final String REFRESH_TOKEN_RESPONSE_BAD_REQUEST = """
            {
                "success": false,
                "message": "",
                "code": 2,
                "errors": null,
                "errorResponse": {
                    "code": 1004,
                    "message": "login yoki parol noto`g`ri"
                },
                "data": null
            }
            """;
}

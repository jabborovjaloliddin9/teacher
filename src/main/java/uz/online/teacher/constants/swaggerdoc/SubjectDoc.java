package uz.online.teacher.constants.swaggerdoc;

public class SubjectDoc {

    public static final String GETONE_RESPONSE_SUCCESS = """
            {
                "success": true,
                "message": null,
                "code": 0,
                "errors": null,
                "errorResponse": null,
                "data": {
                    "id": 1,
                    "name": "Matematika",
                    "subjectTypeDto": {
                        "id": 1,
                        "name": "Nazariy"
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
                            "name": "Matematika"
                        },
                        {
                            "id": 2,
                            "name": "Fizika"
                        },
                        {
                            "id": 3,
                            "name": "Ona tili va adabiyot"
                        },
                        {
                            "id": 4,
                            "name": "Ingliz tili"
                        },
                        {
                            "id": 5,
                            "name": "Rus tili"
                        },
                        {
                            "id": 6,
                            "name": "Kimyo"
                        },
                        {
                            "id": 7,
                            "name": "Biologiya"
                        },
                        {
                            "id": 8,
                            "name": "Tarix"
                        },
                        {
                            "id": 9,
                            "name": "Huquq"
                        },
                        {
                            "id": 10,
                            "name": "Geografiya"
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
                            "name": "Matematika",
                            "subjectTypeDto": {
                                "id": 1,
                                "name": "Nazariy"
                            }
                        },
                        {
                            "id": 2,
                            "name": "Fizika",
                            "subjectTypeDto": {
                                "id": 1,
                                "name": "Nazariy"
                            }
                        },
                        {
                            "id": 3,
                            "name": "Ona tili va adabiyot",
                            "subjectTypeDto": {
                                "id": 1,
                                "name": "Nazariy"
                            }
                        },
                        {
                            "id": 4,
                            "name": "Ingliz tili",
                            "subjectTypeDto": {
                                "id": 1,
                                "name": "Nazariy"
                            }
                        },
                        {
                            "id": 5,
                            "name": "Rus tili",
                            "subjectTypeDto": {
                                "id": 1,
                                "name": "Nazariy"
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
                        "unpaged": false,
                        "paged": true
                    },
                    "last": false,
                    "totalElements": 10,
                    "totalPages": 2,
                    "size": 5,
                    "number": 0,
                    "sort": {
                        "empty": true,
                        "sorted": false,
                        "unsorted": true
                    },
                    "numberOfElements": 5,
                    "first": true,
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
                  },
                  "subjectTypeId": 1
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
                    "name": "Matematika",
                    "subjectTypeDto": {
                        "id": 1,
                        "name": "Nazariy"
                    }
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
                    "message": "SubjectType topilmadi: id = 1"
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
                  },
                  "subjectTypeId": 1
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
                    "name": "Matematika",
                    "subjectTypeDto": {
                        "id": 1,
                        "name": "Nazariy"
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
                    "message": "SubjectType topilmadi: id = 1"
                },
                "data": null
            }
            """;
}

function getcourseList (params) {
    return $axios({
        url: 'http://localhost:83/course/page',
        method: 'get',
        params
    })
}

function editCourse (Params) {
    return $axios({
        url: 'http://localhost:83/course',
        method: 'put',
        data: { ...params }
    })
}

function queryCourseById (id) {
    return $axios({
        url: `http://localhost:83/course/${id}`,
        method: 'get'
    })
}


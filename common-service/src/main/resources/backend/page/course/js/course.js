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
        data: { ...Params }
    })
}

function queryCourseById (id) {
    return $axios({
        url: `http://localhost:83/course/${id}`,
        method: 'get'
    })
}

function addCourse (Params) {
    return $axios({
        url: 'http://localhost:83/course',
        method: 'post',
        data: {...Params }
    })
}

function deleteCourse (id) {
    return $axios({
        url: 'http://localhost:83/course',
        method: 'delete',
        params: id
    })
}


function getaResumeList (params) {
    return $axios({
        url: 'http://localhost:84/resume/page',
        method: 'get',
        params
    })
}

function editResume (Params) {
    return $axios({
        url: 'http://localhost:84/resume',
        method: 'put',
        data: { ...Params }
    })
}

function queryResumeById (id) {
    return $axios({
        url: `http://localhost:84/resume/${id}`,
        method: 'get'
    })
}

function addResume (Params) {
    return $axios({
        url: 'http://localhost:84/resume',
        method: 'post',
        data: {...Params }
    })
}

function deleteResume (id) {
    return $axios({
        url: 'http://localhost:84/resume',
        method: 'delete',
        params: id
    })
}


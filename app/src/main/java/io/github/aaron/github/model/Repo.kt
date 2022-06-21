package io.github.aaron.github.model


import com.google.gson.annotations.SerializedName

data class Repo(
    @SerializedName("archive_url")
    val archiveUrl: String?, // https://api.github.com/repos/dtrupenn/Tetris/{archive_format}{/ref}
    val archived: Boolean?, // true
    @SerializedName("assignees_url")
    val assigneesUrl: String?, // https://api.github.com/repos/dtrupenn/Tetris/assignees{/user}
    @SerializedName("blobs_url")
    val blobsUrl: String?, // https://api.github.com/repos/dtrupenn/Tetris/git/blobs{/sha}
    @SerializedName("branches_url")
    val branchesUrl: String?, // https://api.github.com/repos/dtrupenn/Tetris/branches{/branch}
    @SerializedName("clone_url")
    val cloneUrl: String?, // https://github.com/dtrupenn/Tetris.git
    @SerializedName("collaborators_url")
    val collaboratorsUrl: String?, // https://api.github.com/repos/dtrupenn/Tetris/collaborators{/collaborator}
    @SerializedName("comments_url")
    val commentsUrl: String?, // https://api.github.com/repos/dtrupenn/Tetris/comments{/number}
    @SerializedName("commits_url")
    val commitsUrl: String?, // https://api.github.com/repos/dtrupenn/Tetris/commits{/sha}
    @SerializedName("compare_url")
    val compareUrl: String?, // https://api.github.com/repos/dtrupenn/Tetris/compare/{base}...{head}
    @SerializedName("contents_url")
    val contentsUrl: String?, // https://api.github.com/repos/dtrupenn/Tetris/contents/{+path}
    @SerializedName("contributors_url")
    val contributorsUrl: String?, // https://api.github.com/repos/dtrupenn/Tetris/contributors
    @SerializedName("created_at")
    val createdAt: String?, // 2012-01-01T00:31:50Z
    @SerializedName("default_branch")
    val defaultBranch: String?, // master
    @SerializedName("deployments_url")
    val deploymentsUrl: String?, // https://api.github.com/repos/dtrupenn/Tetris/deployments
    val description: String?, // A C implementation of Tetris using Pennsim through LC4
    val disabled: Boolean?, // true
    @SerializedName("downloads_url")
    val downloadsUrl: String?, // https://api.github.com/repos/dtrupenn/Tetris/downloads
    @SerializedName("events_url")
    val eventsUrl: String?, // https://api.github.com/repos/dtrupenn/Tetris/events
    val fork: Boolean?, // false
    val forks: Int?, // 1
    @SerializedName("forks_count")
    val forksCount: Int?, // 0
    @SerializedName("forks_url")
    val forksUrl: String?, // https://api.github.com/repos/dtrupenn/Tetris/forks
    @SerializedName("full_name")
    val fullName: String?, // dtrupenn/Tetris
    @SerializedName("git_commits_url")
    val gitCommitsUrl: String?, // https://api.github.com/repos/dtrupenn/Tetris/git/commits{/sha}
    @SerializedName("git_refs_url")
    val gitRefsUrl: String?, // https://api.github.com/repos/dtrupenn/Tetris/git/refs{/sha}
    @SerializedName("git_tags_url")
    val gitTagsUrl: String?, // https://api.github.com/repos/dtrupenn/Tetris/git/tags{/sha}
    @SerializedName("git_url")
    val gitUrl: String?, // git:github.com/dtrupenn/Tetris.git
    @SerializedName("has_downloads")
    val hasDownloads: Boolean?, // true
    @SerializedName("has_issues")
    val hasIssues: Boolean?, // true
    @SerializedName("has_pages")
    val hasPages: Boolean?, // true
    @SerializedName("has_projects")
    val hasProjects: Boolean?, // true
    @SerializedName("has_wiki")
    val hasWiki: Boolean?, // true
    val homepage: String?, // https://github.com
    @SerializedName("hooks_url")
    val hooksUrl: String?, // https://api.github.com/repos/dtrupenn/Tetris/hooks
    @SerializedName("html_url")
    val htmlUrl: String?, // https://github.com/dtrupenn/Tetris
    val id: Int?, // 3081286
    @SerializedName("issue_comment_url")
    val issueCommentUrl: String?, // https://api.github.com/repos/dtrupenn/Tetris/issues/comments{/number}
    @SerializedName("issue_events_url")
    val issueEventsUrl: String?, // https://api.github.com/repos/dtrupenn/Tetris/issues/events{/number}
    @SerializedName("issues_url")
    val issuesUrl: String?, // https://api.github.com/repos/dtrupenn/Tetris/issues{/number}
    @SerializedName("keys_url")
    val keysUrl: String?, // https://api.github.com/repos/dtrupenn/Tetris/keys{/key_id}
    @SerializedName("labels_url")
    val labelsUrl: String?, // https://api.github.com/repos/dtrupenn/Tetris/labels{/name}
    val language: String?, // Assembly
    @SerializedName("languages_url")
    val languagesUrl: String?, // https://api.github.com/repos/dtrupenn/Tetris/languages
    val license: License?,
    @SerializedName("master_branch")
    val masterBranch: String?, // master
    @SerializedName("merges_url")
    val mergesUrl: String?, // https://api.github.com/repos/dtrupenn/Tetris/merges
    @SerializedName("milestones_url")
    val milestonesUrl: String?, // https://api.github.com/repos/dtrupenn/Tetris/milestones{/number}
    @SerializedName("mirror_url")
    val mirrorUrl: String?, // git:git.example.com/dtrupenn/Tetris
    val name: String?, // Tetris
    @SerializedName("node_id")
    val nodeId: String?, // MDEwOlJlcG9zaXRvcnkzMDgxMjg2
    @SerializedName("notifications_url")
    val notificationsUrl: String?, // https://api.github.com/repos/dtrupenn/Tetris/notifications{?since,all,participating}
    @SerializedName("open_issues")
    val openIssues: Int?, // 1
    @SerializedName("open_issues_count")
    val openIssuesCount: Int?, // 0
    val owner: Owner?,
    val `private`: Boolean?, // false
    @SerializedName("pulls_url")
    val pullsUrl: String?, // https://api.github.com/repos/dtrupenn/Tetris/pulls{/number}
    @SerializedName("pushed_at")
    val pushedAt: String?, // 2012-01-01T00:37:02Z
    @SerializedName("releases_url")
    val releasesUrl: String?, // https://api.github.com/repos/dtrupenn/Tetris/releases{/id}
    val score: Int?, // 1
    val size: Int?, // 524
    @SerializedName("ssh_url")
    val sshUrl: String?, // git@github.com:dtrupenn/Tetris.git
    @SerializedName("stargazers_count")
    val stargazersCount: Int?, // 1
    @SerializedName("stargazers_url")
    val stargazersUrl: String?, // https://api.github.com/repos/dtrupenn/Tetris/stargazers
    @SerializedName("statuses_url")
    val statusesUrl: String?, // https://api.github.com/repos/dtrupenn/Tetris/statuses/{sha}
    @SerializedName("subscribers_url")
    val subscribersUrl: String?, // https://api.github.com/repos/dtrupenn/Tetris/subscribers
    @SerializedName("subscription_url")
    val subscriptionUrl: String?, // https://api.github.com/repos/dtrupenn/Tetris/subscription
    @SerializedName("svn_url")
    val svnUrl: String?, // https://svn.github.com/dtrupenn/Tetris
    @SerializedName("tags_url")
    val tagsUrl: String?, // https://api.github.com/repos/dtrupenn/Tetris/tags
    @SerializedName("teams_url")
    val teamsUrl: String?, // https://api.github.com/repos/dtrupenn/Tetris/teams
    @SerializedName("trees_url")
    val treesUrl: String?, // https://api.github.com/repos/dtrupenn/Tetris/git/trees{/sha}
    @SerializedName("updated_at")
    val updatedAt: String?, // 2013-01-05T17:58:47Z
    val url: String?, // https://api.github.com/repos/dtrupenn/Tetris
    val visibility: String?, // private
    val watchers: Int?, // 1
    @SerializedName("watchers_count")
    val watchersCount: Int? // 1
) {
    data class License(
        @SerializedName("html_url")
        val htmlUrl: String?, // https://api.github.com/licenses/mit
        val key: String?, // mit
        val name: String?, // MIT License
        @SerializedName("node_id")
        val nodeId: String?, // MDc6TGljZW5zZW1pdA==
        @SerializedName("spdx_id")
        val spdxId: String?, // MIT
        val url: String? // https://api.github.com/licenses/mit
    )

    data class Owner(
        @SerializedName("avatar_url")
        val avatarUrl: String?, // https://secure.gravatar.com/avatar/e7956084e75f239de85d3a31bc172ace?d=https://a248.e.akamai.net/assets.github.com%2Fimages%2Fgravatars%2Fgravatar-user-420.png
        @SerializedName("events_url")
        val eventsUrl: String?, // https://api.github.com/users/octocat/events{/privacy}
        @SerializedName("followers_url")
        val followersUrl: String?, // https://api.github.com/users/octocat/followers
        @SerializedName("following_url")
        val followingUrl: String?, // https://api.github.com/users/octocat/following{/other_user}
        @SerializedName("gists_url")
        val gistsUrl: String?, // https://api.github.com/users/octocat/gists{/gist_id}
        @SerializedName("gravatar_id")
        val gravatarId: String?,
        @SerializedName("html_url")
        val htmlUrl: String?, // https://github.com/octocat
        val id: Int?, // 872147
        val login: String?, // dtrupenn
        @SerializedName("node_id")
        val nodeId: String?, // MDQ6VXNlcjg3MjE0Nw==
        @SerializedName("organizations_url")
        val organizationsUrl: String?, // https://api.github.com/users/octocat/orgs
        @SerializedName("received_events_url")
        val receivedEventsUrl: String?, // https://api.github.com/users/dtrupenn/received_events
        @SerializedName("repos_url")
        val reposUrl: String?, // https://api.github.com/users/octocat/repos
        @SerializedName("site_admin")
        val siteAdmin: Boolean?, // true
        @SerializedName("starred_url")
        val starredUrl: String?, // https://api.github.com/users/octocat/starred{/owner}{/repo}
        @SerializedName("subscriptions_url")
        val subscriptionsUrl: String?, // https://api.github.com/users/octocat/subscriptions
        val type: String?, // User
        val url: String? // https://api.github.com/users/dtrupenn
    )
}
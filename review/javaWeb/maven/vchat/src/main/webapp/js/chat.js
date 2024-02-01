// 测试数据，后端返回的格式如下
messages = [
    {
        who: '昌晶晶',
        toWho: '张三',
        time: 1383254400,
        msg: '一条信息',
        who_pic: "./imgs/avatar.jpg",
        toWho_pic: "./imgs/1.jpg"
    },
    {
        who: '张三',
        toWho: '昌晶晶',
        time: 1583254333,
        msg: '一条信息',
        who_pic: "./imgs/1.jpg",
        toWho_pic: "./imgs/avatar.jpg"
    },
    {
        who: '李四',
        toWho: '昌晶晶',
        time: 1701241542,
        msg: '李四发的消息1',
        who_pic: "./imgs/1.jpg",
        toWho_pic: "./imgs/avatar.jpg"
    },
    {
        who: '昌晶晶',
        toWho: '李四',
        time: 1383254400,
        msg: '9. 感性认识与理性认识的辩证关系及其方法论意义\
        感性认识和理性认识有着密不可分的辩证联系。首先，理性认识依赖于感性认识，理性认识必须以感性认识为基础。坚持理性认识对于感性认识的依赖关系，就是坚持了认识论的唯物论。其次，感性认识有待于发展和深化为理性认识。只有使感性认识上升到理性认识，才能把握住事物的本质，满足时间的需要。坚持了这一点，就是坚持了认识论的辩证法。最后，感性认识和理性认识相互渗透，相互包容，二者的区分是相对的，人们不应当也不可能把它们截然分开。\
        感性认识和理性认识是辩证统一的',
        who_pic: "./imgs/avatar.jpg",
        toWho_pic: "./imgs/1.jpg"
    },
    {
        who: '李四',
        toWho: '昌晶晶',
        time: 1701241542,
        msg: '9. 感性认识与理性认识的辩证关系及其方法论意义\
        感性认识和理性认识有着密不可分的辩证联系。首先，理性认识依赖于感性认识，理性认识必须以感性认识为基础。坚持理性认识对于感性认识的依赖关系，就是坚持了认识论的唯物论。其次，感性认识有待于发展和深化为理性认识。只有使感性认识上升到理性认识，才能把握住事物的本质，满足时间的需要。坚持了这一点，就是坚持了认识论的辩证法。最后，感性认识和理性认识相互渗透，相互包容，二者的区分是相对的，人们不应当也不可能把它们截然分开。\
        感性认识和理性认识是辩证统一的',
        who_pic: "./imgs/1.jpg",
        toWho_pic: "./imgs/avatar.jpg"
    },
    {
        who: '王五',
        toWho: '昌晶晶',
        time: 1701241542,
        msg: 'abc',
        who_pic: "./imgs/1.jpg",
        toWho_pic: "./imgs/avatar.jpg"
    },
    {
        who: '赵六',
        toWho: '昌晶晶',
        time: 1701241542,
        msg: '发送信息了',
        who_pic: "./imgs/1.jpg",
        toWho_pic: "./imgs/avatar.jpg"
    },
    {
        who: '昌晶晶',
        toWho: '田七',
        time: 1701241242,
        msg: '发送信息了',
        who_pic: "./imgs/1.jpg",
        toWho_pic: "./imgs/avatar.jpg"
    },
    {
        who: '昌晶晶',
        toWho: '1',
        time: 1701241242,
        msg: '发送信息了',
        who_pic: "./imgs/1.jpg",
        toWho_pic: "./imgs/avatar.jpg"
    },
    {
        who: '昌晶晶',
        toWho: '2',
        time: 1701241242,
        msg: '发送信息了',
        who_pic: "./imgs/1.jpg",
        toWho_pic: "./imgs/avatar.jpg"
    },
    {
        who: '昌晶晶',
        toWho: '3',
        time: 1701241242,
        msg: '发送信息了',
        who_pic: "./imgs/1.jpg",
        toWho_pic: "./imgs/avatar.jpg"
    },
    {
        who: '昌晶晶',
        toWho: '4',
        time: 1701241242,
        msg: '发送信息了',
        who_pic: "./imgs/1.jpg",
        toWho_pic: "./imgs/avatar.jpg"
    },
    {
        who: '昌晶晶',
        toWho: '5',
        time: 1701241242,
        msg: '发送信息了',
        who_pic: "./imgs/1.jpg",
        toWho_pic: "./imgs/avatar.jpg"
    },
    {
        who: '昌晶晶',
        toWho: '6',
        time: 1701241242,
        msg: '发送信息了',
        who_pic: "./imgs/1.jpg",
        toWho_pic: "./imgs/avatar.jpg"
    },
    {
        who: '昌晶晶',
        toWho: '7',
        time: 1701241242,
        msg: '发送信息了',
        who_pic: "./imgs/1.jpg",
        toWho_pic: "./imgs/avatar.jpg"
    }
]

// 从登录页面得到的用户名以及密码
user_info = ["昌晶晶", "123"];


//////////////////////////////////////////////////////////////////////////////////////////////////
// GET / POST请求
//////////////////////////////////////////////////////////////////////////////////////////////////

// GET请求信息
// 1、会更新全局的数据
// 2、更新好友列表
function GET_allInfo() {
    $.ajax({
        url: "/vchat",
        type: "GET",
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify({
            user_name: user_info[0],
            user_password: user_info[1]
        }),
        success: function (data) {
            messages = data;
            loadFriendList(getLastTimeMsg(messages));
        }
    });
    loadFriendList(getLastTimeMsg(messages));
}

// POST上传数据
// 谁 / 对谁 / 发了什么？
// 发送的是从textarea拿到的数据
function POST_sendMessage(who, toWho, text) {
    $.ajax({
        url: "/vchat",
        type: "POST",
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify({
            who: who,
            toWho: toWho,
            msg: text
        }),
        success: function (data) {
            GET_allInfo();
            console.log("send success");
        }
    });
}


//////////////////////////////////////////////////////////////////////////////////////////////////
// GET功能函数
//////////////////////////////////////////////////////////////////////////////////////////////////

// 更新html的好友列表 
function loadFriendList(arr) {
    let ul = document.querySelector(".list>ul");
    let i_whohadclicked = -1;
    for (let i = ul.childNodes.length - 1; i >= 0; i--) {
        if (ul.childNodes[i].id) {
            i_whohadclicked = i;
        }
        ul.removeChild(ul.childNodes[i]);
    }

    for (let msg of arr) {
        let other_name = msg.who == user_info[0] ? msg.toWho : msg.who;
        let li = document.createElement("li");
        li.className = "people";

        let img = document.createElement("img");
        img.src = msg.who_pic;

        let div = document.createElement("div");
        div.className = "content";

        let span1 = document.createElement("span");
        let span2 = document.createElement("span");
        span1.innerHTML = other_name;
        span2.innerHTML = getTime(msg.time);
        span2.className = "time";

        let p = document.createElement("p");
        p.innerHTML = msg.msg.length > 13 ? msg.msg.slice(0, 10) + "..." : msg.msg;

        div.appendChild(span1);
        div.appendChild(span2);
        div.appendChild(p);
        li.appendChild(img);
        li.appendChild(div);
        ul.appendChild(li);

        li.addEventListener("click", function () {
            let lis = document.querySelectorAll(".people");
            for (li of lis) {
                li.id = "";
            }
            this.id = "chosen";
            GET_allInfo();
            loadMainChat(getMainChatMessage(other_name));
        });
    }
    if (ul.hasChildNodes) {
        ul.childNodes[i_whohadclicked].id = "chosen";
    }
}

// 从数据中拿到自己和对方最后一次的聊天信息
// 可以通过这个数据更新好友列表
function getLastTimeMsg(msgs) {
    let hash = new Map();

    for (let msg of msgs) {
        let key = [msg.who, msg.toWho].sort().join('-');
        if (!hash.has(key) || hash.get(key).time < msg.time) {
            hash.set(key, msg);
        }
    }
    return Array.from(hash.values());
}

// 时间戳转字符串时间
function getTime(timestamp) {
    let now = new Date();
    let inputDate = new Date(timestamp * 1000);

    let year = inputDate.getFullYear();
    let month = ("0" + (inputDate.getMonth() + 1)).slice(-2);
    let day = ("0" + inputDate.getDate()).slice(-2);
    let hour = ("0" + inputDate.getHours()).slice(-2);
    let minute = ("0" + inputDate.getMinutes()).slice(-2);

    if (now.getFullYear() > year) {
        return year + "-" + month + "-" + day;
    } else if (now.getMonth() > inputDate.getMonth() || now.getDate() > day) {
        return month + "-" + day;
    } else {
        return hour + ":" + minute;
    }
}

// 更新主聊天窗口
function loadMainChat(arr) {

    arr.sort((a, b) => { return a.time < b.time });

    let title = document.querySelector(".name>p");
    title.innerHTML = arr[0].who == user_info[0] ? arr[0].toWho : arr[0].who;
    let ul = document.querySelector(".chat>ul");

    for (let i = ul.childNodes.length - 1; i >= 0; i--) {
        ul.removeChild(ul.childNodes[i]);
    }

    for (let msg of arr) {
        let li = document.createElement("li");

        let p = document.createElement("p");
        let div = document.createElement("div");
        let img = document.createElement("img");

        if (msg.who == user_info[0]) {
            li.className = "me";
            p.innerHTML = msg.msg;
            div.className = "icon";
            img.src = msg.who_pic;
            li.appendChild(p);
            li.appendChild(div);
            li.appendChild(img);
        } else {
            li.className = "other";
            p.innerHTML = msg.msg;
            div.className = "icon";
            img.src = msg.who_pic;
            li.appendChild(img);
            li.appendChild(div);
            li.appendChild(p);
        }
        ul.appendChild(li);
    }


}

function getMainChatMessage(other) {
    let ret = [];
    for (let msg of messages) {
        if (other == msg.who || other == msg.toWho) {
            ret.push(msg);
        }
    }
    return ret;
}



//////////////////////////////////////////////////////////////////////////////////////////////////
// POST功能函数
//////////////////////////////////////////////////////////////////////////////////////////////////

function sendMessage() {
    let text = document.querySelector(".input>textarea");
    let other = document.querySelector("#chosen");
    if (text.value && other) {
        POST_sendMessage(user_info[0], other.childNodes[1].childNodes[0].innerHTML, text.value);
    }
    text.value = "";
}
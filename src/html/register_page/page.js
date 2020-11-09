let flag = false;
let code;

/**
 * 设置表单提交方式
 */
//document.getElementsByTagName('form')[0].setAttribute('method','post');

/**
 * username绑定onblur
 */
document.getElementsByName('username')[0].onblur = () => checkUsername();

/**
 * password绑定onblur
 */
document.getElementsByName('password')[0].onblur = () => {
    let td = document.getElementById('pw_note');
    if (check('password', /^.+$/)) {
        td.innerHTML = `<img class='icon' src='img/对勾.png'/>`;
    } else {
        td.innerHTML = `<span>*</span>请输入6~16位字符`;
    }
}

/**
 * password2绑定onblur
 */
document.getElementById('pw2').onblur = () => checkPassword();

/**
 * telephone绑定onblur
 */
document.getElementsByName('telephone')[0].onblur = () => {
    let td = document.getElementById('telephone_note');
    if (check('telephone', /^\d+$/)) {
        td.innerHTML = `<img class='icon' src='img/对勾.png'/>`;
    } else {
        td.innerHTML = `<span>*</span>请输入正确的手机号码`;
    }
}
/**
 * email绑定onblur
 */
document.getElementsByName('email')[0].onblur = () => {
    let td = document.getElementById('email_note');
    if (check('email', /^[_\da-zA-Z]+@[_\da-zA-Z]+$/)) {
        td.innerHTML = `<img class='icon' src='img/对勾.png'/>`;
    } else {
        td.innerHTML = `<span>*</span>请填写常用的电子邮箱用于找回密码`;
    }
}
/**
 * qq绑定onblur
 */
document.getElementsByName('qq')[0].onblur = () => {
    let td = document.getElementById('qq_note');
    if (check('qq', /^\d+$/)) {
        td.innerHTML = `<img class='icon' src='img/对勾.png'/>`;
    } else {
        td.innerHTML = `<span>*</span>请填写常用的QQ号码`;
    }
}

/**
 * 提交表单
 */
onsubmit = () => {
    let flag = checkPassword()&&checkUsername()&&checkCode()&&
        document.getElementById('agree').checked;
    if (flag)
        alert('注册成功');
    else
        alert('注册失败');
}

document.getElementById('codeBtn').onclick=()=>{
    code=Math.floor(Math.random()*10000).toPrecision(4);
}


/**
 * 检查输入字段
 * @param name 标签name属性值
 * @param reg 正则表达式
 * @returns {boolean} 是否符合要求
 */
function check(name, reg) {
    let val = document.getElementsByName(name)[0].value;
    return reg.test(val);
}

/**
 * 检查用户名输入
 * @returns {boolean}
 */
function checkUsername(){
    let td = document.getElementById('username_note');
    if (check('username', /^[_\da-zA-Z]{6,12}$/)) {
        td.innerHTML = `<img class='icon' src='img/对勾.png'/>`;
        return true;
    } else {
        td.innerHTML = `<span>*</span>请输入6~12位 _ 、数字、字母`;
        return false
    }
}

/**
 * 检查密码输入
 * @returns {boolean}
 */
function checkPassword(){
    let td = document.getElementById('pw_note2');
    let val1 = document.getElementsByName('password')[0].value;
    let val2 = document.getElementById('pw2').value;
    if (val1 == val2) {
        td.innerHTML = `<img class='icon' src='img/对勾.png'/>`;
        return true;
    } else {
        td.innerHTML = `<span>两次密码不匹配</span>`;
        return false;
    }
}

/**
 * 检查验证码
 * @returns {boolean}
 */
function checkCode(){
    let val= document.getElementById('codeInput').value;
    return val==code;
}
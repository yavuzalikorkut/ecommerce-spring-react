import React from 'react'
import { Dropdown, Menu, Image } from 'semantic-ui-react'

//normalde propsu statei degistirmek icin bir ust komponentten props nesnesi olarak bu alt komponente yolluyorz-->SıgnedIn(props)
// ve alt  komponentte de kullan ıstedıgımzde props.signOut        props.signIn      gibi kullanıyoruz
//boyle yapmaktansa daha net olamk icin destructin ile parametrelerin ne oldugunu acıkca belirtebilriz (object destructin)
//{object1, object2, ... ,objectn} = props
//{signOut, .....} = props     --kulllanmak istedigimizdede signOut artık bir object var oldu ıcın sadece signOut dememiz yeterli idi
export default function SignedIn({signOut}) {
    return (
        <div>
            <Menu.Item>
                <Image avatar spaced="right" src="https://upload.wikimedia.org/wikipedia/commons/a/a0/Pierre-Person.jpg"/>
                <Dropdown pointing="top right" text="Engin">
                    <Dropdown.Menu>
                        <Dropdown.Item text="Bilgilerim" icon="info"/>
                        <Dropdown.Item onClick={signOut} text="Çıkış Yap" icon="sign-out"/> 
                        {/* onClick={props.signOut} */}
                    </Dropdown.Menu>
                </Dropdown>
            </Menu.Item>
        </div>
    )
}

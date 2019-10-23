import { Injectable } from '@angular/core';

/*
 * Menu interface
 */
export interface Menu {
	state: string;
	name?: string;
	type?: string;
	icon?: string;
	children?: Menu[];
}

const HeaderOneItems= [
  {  
    state:'home-three',
    name: 'HOME THREE',
    type: 'link',
    icon: 'home'
  },
  {
    state: "",
    name : "SHOP",
    type: "sub",
    icon: "pages",
    children: [
      {  
        state: 'products/clothing/4', 
        name: 'PRODUCT DETAILS',
        type: 'link',
        icon: 'arrow_right_alt'
      },
      {  
        state: 'cart', 
        name: 'CART',
        type: 'link',
        icon: 'arrow_right_alt'
      },
      {  
        state: 'checkout', 
        name: 'CHECKOUT',
        type: 'link',
        icon: 'arrow_right_alt'
      },
      {  
        state: 'checkout/payment', 
        name: 'PAYMENT',
        type: 'link',
        icon: 'arrow_right_alt'
      }
    ]
  },
 
 
  {
    state:'products/accessories',
    name:"ACCESSORIES",
    type:"link",
    icon: 'party_mode'
  },
  {
    state:'products',
    name:"CATEGORIES",
    type:"sub",
    mega:true,
    icon: 'party_mode',
    children: [
      {  
        state: 'clothing', 
        name: 'DAILY',
        type: 'sub',
        icon: 'arrow_right_alt',
        children:[
          {  
            state: 'products/clothing', 
            queryState:'Jeans',
            name: 'mens',
            type: 'queryParams',
            icon: 'arrow_right_alt',
          },
          {  
            state: 'products/clothing', 
            queryState:'Jackets',
            name: 'Laptops',
            type: 'queryParams',
            icon: 'arrow_right_alt',
          },
          {
            state: 'products/clothing', 
            queryState:'Shirt',  
            name: 'Smartwatches',
            type: 'queryParams',
            icon: 'arrow_right_alt',
          },
          {  
            state: 'products/clothing', 
            queryState:'T-Shirt',
            name: 'Earphones/Headphones',
            type: 'queryParams',
            icon: 'arrow_right_alt',
          }
        ]
      },
      {  
        state: 'woman', 
        name: 'PRO',
        type: 'sub',
        icon: 'arrow_right_alt',
        children:[
          {  
            state: 'products/woman', 
            queryState:'Dresses',
            name: 'DRESS',
            type: 'queryParams',
            icon: 'arrow_right_alt',
          },
          {  
            state: 'products/woman', 
            queryState:'Shirt',
            name: 'SHIRT',
            type: 'queryParams',
            icon: 'arrow_right_alt',
          },
          {  
            state: 'products/woman', 
            queryState:'T-Shirt',
            name: 'T-SHIRT',
            type: 'queryParams',
            icon: 'arrow_right_alt',
          }
        ]
      },
      {  
        state: 'gadgets', 
        name: 'Hobby',
        type: 'sub',
        icon: 'arrow_right_alt',
        children:[
          {  
            state: 'products/gadgets', 
            queryState:'Headphone', 
            name: 'HEADPHONE',
            type: 'queryParams',
            icon: 'arrow_right_alt',
          },
          {  
            state: 'products/gadgets', 
            queryState:'clothing',
            name: 'clothing',
            type: 'queryParams',
            icon: 'arrow_right_alt',
          },
          {  
            state: 'products/gadgets', 
            queryState:'Watch',
            name: 'WATCH',
            type: 'queryParams',
            icon: 'arrow_right_alt',
          },
          {  
            state: 'products/gadgets', 
            queryState:'Speaker',
            name: 'SPEAKER',
            type: 'queryParams',
            icon: 'arrow_right_alt',
          }
        ]
      },
      {  
        state: 'accessories', 
        name: 'NEWS',
        type: 'sub',
        icon: 'arrow_right_alt',
        children:[
          {  
            state: 'products/accessories', 
            queryState:'Laptap',
            name: 'Laptops',
            type: 'queryParams',
            icon: 'arrow_right_alt',
          },
          {  
            state: 'products/accessories', 
            queryState:'Belts',
            name: 'VR Headsets',
            type: 'queryParams',
            icon: 'arrow_right_alt',
          },
          {  
            state: 'products/accessories', 
            queryState:'Jewellery', 
            name: 'Reader',
            type: 'queryParams',
            icon: 'arrow_right_alt',
          }
        ]
      }
    ]
  },
  {
  state: "pages",
  name: "USER ACCOUNT",
  type: "sub",
  icon: "pages",
  children: [
      {  
         state: 'account/profile', 
         name: 'User Profile',
         type: 'link',
         icon: 'arrow_right_alt',
      },
      {
        state:'session',
        name:"SESSION",
        type:"subChild",
        icon: 'supervised_user_circle',
        children: [
            {  
            state: 'session/signin', 
            name: 'SIGN IN',
            type: 'link',
            icon: 'arrow_right_alt',
            },
            {  
                state: 'session/signup', 
                name: 'REGISTER',
                type: 'link',
                icon: 'arrow_right_alt',
            },
            {  
                state: 'session/forgot-password', 
                name: 'FORGET PASSWORD',
                type: 'link',
                icon: 'arrow_right_alt',
            },
          ]
       }
    ],
},
  {
    state:'contact',
    name:"CONTACT US",
    type:"link",
    icon: 'perm_contact_calendar'
  },
  {
    state:'admin-panel',
    name:"Admin Portal",
    type:"link",
    icon: 'perm_identity'
  }
];

const FooterOneItems= [
  {
     state:'',
     name:"ABOUT",
     type:"sub",
     icon: '',
     children: [
       {  
         state:'contact',
         name:"CONTACT US",
         type:"link",
         icon: 'perm_contact_calendar',
       }
    ]
  }, 
  {
    state:'',
    name:"SESSION",
    type:"sub",
    icon: '',
    children: [
        {  
        state: 'session/signin', 
        name: 'SIGN IN',
        type: 'link',
        icon: 'arrow_right_alt',
        },
        {  
            state: 'session/signup', 
            name: 'REGISTER',
            type: 'link',
            icon: 'arrow_right_alt',
        },
        {  
            state: 'session/forgot-password', 
            name: 'FORGET PASSWORD',
            type: 'link',
            icon: 'arrow_right_alt',
        },
        
    ]
  },
  {
    state:'',
    name:"CATEGORIES",
    type:"sub",
    icon: '',
    children: [
      {  
        state: 'products/women', 
        name: 'Pro',
        type: 'link',
        icon: 'arrow_right_alt',
      },
      {  
        state: 'products/clothing', 
        name: 'Daily',
        type: 'link',
        icon: 'arrow_right_alt',
      },
      {  
        state: 'products/accesories', 
        name: 'New',
        type: 'link',
        icon: 'arrow_right_alt',
      },
      {  
        state: 'products/gadgets', 
        name: 'Hobby',
        type: 'link',
        icon: 'arrow_right_alt',
      }
    ]
  },
  {
    state:'',
    name:"SOCIAL",
    type:"sub",
    icon: '',
    children: [
      {
        state: 'https://www.facebook.com/', 
        name: 'Facebook',
        type: 'social_link',
        icon: 'arrow_right_alt',
      },
      {
        state: 'https://twitter.com/', 
        name: 'Twitter',
        type: 'social_link',
        icon: 'arrow_right_alt',
      },
      {
        state: 'https://www.youtube.com/', 
        name: 'Youtube',
        type: 'social_link',
        icon: 'arrow_right_alt',
      },
      {
        state: 'https://plus.google.com', 
        name: 'Google Plus',
        type: 'social_link',
        icon: 'arrow_right_alt',
      }
    ]
  }

]

@Injectable()
export class MenuItems {

   /*
    * Get all header menu
    */
   getMainMenu(): Menu[] {
      return HeaderOneItems;
   }

   /*
    * Get all footer menu
    */
   getFooterOneMenu(): Menu[] {
      return FooterOneItems;
   }
}

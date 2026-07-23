src/
├── api/
│   ├── axiosInstance.ts        # axios config + interceptors
│   └── endpoints.ts            # saare API paths ek jagah
├── features/
│   └── randomUsers/
│       ├── randomUsers.api.ts      # react-query fetch functions
│       ├── randomUsers.slice.ts    # redux slice (agar local state chahiye)
│       ├── useRandomUsers.ts       # custom react-query hook
│       └── RandomUsersList.tsx     # component
├── store/
│   ├── store.ts                # redux store config
│   └── hooks.ts                # typed useDispatch/useSelector
├── providers/
│   └── QueryProvider.tsx       # QueryClientProvider wrapper
├── types/
│   └── user.types.ts           # TS interfaces
├── App.tsx
└── main.tsx
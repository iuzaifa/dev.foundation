import React, { useState } from 'react'

const Dashboard = () => {
  const [menu , setMenu] = useState(false)
  const [submenu, setSubmenue] = useState(false)
  return (
    <>
      <p>Main Dashboard</p>

      <ul>
        <li onClick={() => setMenu((prev) => !prev)}>Home</li>
        {menu && (
          <ul>
            <li onClick={() => setSubmenue((prev) => !prev)}>
              Home 1
              {submenu && (
                <ul>
                  <li>SUBMENUW 1</li>
                  <li>SUBMENUW 2</li>
                  <li>SUBMENUW 3</li>
                </ul>
              )}
            </li>
            <li>Home 2</li>
            <li>Home 3</li>
          </ul>
        )}
      </ul>
    </>
  );
}

export default Dashboard
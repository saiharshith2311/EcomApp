import React from 'react'

export default function Price({price, currency}) {
  return (
    <>
      {currency} <span>{price}</span>
    </>
  )
}

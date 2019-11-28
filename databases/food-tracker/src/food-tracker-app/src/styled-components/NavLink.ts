import { Link } from 'react-router-dom';
import styled from 'styled-components';

const NavLink = styled(Link)`
    padding: 20px;
    text-decoration: none;
    color: inherit;
    &:hover {
        background: #4080f0
    }
`;

export default NavLink;
